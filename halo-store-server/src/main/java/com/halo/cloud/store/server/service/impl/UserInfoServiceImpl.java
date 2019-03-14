package com.halo.cloud.store.server.service.impl;


import com.halo.cloud.dto.store.BackstageUserProfileDTO;
import com.halo.cloud.dto.store.UserProfileInfoDTO;
import com.halo.cloud.dto.store.UserRegisterInfoDTO;
import com.halo.cloud.entity.store.UserProfile;
import com.halo.cloud.entity.store.UserRegistry;
import com.halo.cloud.store.server.dao.UserAddressDao;
import com.halo.cloud.store.server.dao.UserProfileDao;
import com.halo.cloud.store.server.dao.UserRegistryDao;
import com.halo.cloud.store.server.service.UserInfoService;
import com.halo.cloud.util.UploadUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.halo.cloud.util.DigestUtil;

import javax.servlet.http.Part;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/26
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger log= LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserRegistryDao userRegistryDao;
    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private UserAddressDao userAddressDao;

    @Override
    public Integer getIdByPhone(String phone) {
        return userRegistryDao.getIdByPhone(phone);
    }

    @Override
    public Integer getIdByUsername(String username) {
        return userProfileDao.getIdByUsername(username);
    }

    @Override
    public Integer getIdByEmail(String email) {
        return userProfileDao.getIdByEmail(email);
    }

    @Override
    public Integer verifyLoginInfo(String phone, String password) {
        UserRegistry userRegistry = userRegistryDao.getByPhone(phone);
        if (userRegistry != null && DigestUtil.verify(password, userRegistry.getSalt(), userRegistry.getPwd())) {
            return userRegistry.getId();
        }
        return -1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer insertUserInfo(UserRegisterInfoDTO userRegisterInfoDTO) {
        // 插入注册信息
        UserRegistry userRegistry = new UserRegistry();
        userRegistry.setPhone(userRegisterInfoDTO.getPhone());
        String salt = DigestUtil.generateSalt();
        String pwd = DigestUtil.sha256(userRegisterInfoDTO.getPwd() + salt);
        userRegistry.setPwd(pwd);
        userRegistry.setSalt(salt);
        userRegistryDao.insertUserRegistryInfo(userRegistry);
        Integer uid = userRegistry.getId();

        // 插入个人信息
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(uid);
        userProfile.setUsername(userRegisterInfoDTO.getUsername());
        userProfile.setPhone(userRegisterInfoDTO.getPhone());
        userProfileDao.insertUserProfileInfo(userProfile);

        return uid;
    }

    @Override
    public UserProfileInfoDTO getUserProfileInfoByUId(Integer userId) {
        try {
            UserProfile userProfile = userProfileDao.getUserProfileInfoByUId(userId);
            return new UserProfileInfoDTO(
                    userProfile.getUsername(), "//" + userProfile.getAvatar(), userProfile.getSecurityLevel(), userProfile.getEmail(),
                    userProfile.getPhone(), userProfile.getPwdProtection());
        }catch (Exception e){
            log.error("[getUserProfileInfoByUId] error:{}",e,e.getMessage());
            return null;
        }

    }


    @Override
    public Integer getHaloCoinByUId(Integer userId) {
        return userProfileDao.getHaloCoinByUId(userId);
    }

    @Override
    public boolean verifyPwd(String pwd, Integer userId) {
        UserRegistry userRegistry = userRegistryDao.getByUId(userId);
        String password = userRegistry.getPwd();
        String salt = userRegistry.getSalt();
        return DigestUtil.sha256(pwd + salt).equals(password);
    }

    @Override
    public boolean updateCoinByUId(Integer number, Integer userId) {
        Integer sum = number + userProfileDao.getHaloCoinByUId(userId);
        return userProfileDao.updateCoinByUId(sum, userId) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String updateAvatarByUId(Part part, Integer userId) throws IOException {
        String imgUrl;
        try (BufferedInputStream in = new BufferedInputStream(part.getInputStream())) {
            int size = (int) part.getSize();
            byte[] buffer = new byte[size];
            int i = in.read(buffer);
            while ((i > 0)) {
                i = in.read(buffer);
            }
            imgUrl = UploadUtil.uploadToQiNiuYun(buffer);
            userProfileDao.updateAvatarById(imgUrl, userId);
        }
        return "//" + imgUrl;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePwdByUId(String newPwd, Integer userId) {
        String newSalt = DigestUtil.generateSalt();
        String password = DigestUtil.sha256(newPwd + newSalt);
        return userRegistryDao.updatePwdByUId(newSalt, password, userId) != null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateEmailByUId(String email, Integer userId) {
        return userProfileDao.updateEmailById(email, userId) != null;
    }

    @Override
    public boolean updatePhoneByUId(String phone, Integer userId) {
        return userRegistryDao.updatePhoneByUId(phone, userId) != null && userProfileDao.updatePhoneByUId(phone, userId) != null;
    }

    @Override
    public boolean updatePwdByPhone(String pwd, String phone) {
        return userRegistryDao.updatePwdByPhone(pwd, phone) != null;
    }

    @Override
    public List<BackstageUserProfileDTO> getUsersProfile(Integer pageIndex, Integer pageCount) {
        pageIndex = (pageIndex - 1) * pageCount;
        List<UserProfile> userProfileList = userProfileDao.getUsersProfile(pageIndex, pageCount);
        List<BackstageUserProfileDTO> backstageUserProfileDTOList = new ArrayList<>();
        BackstageUserProfileDTO b;
        for (UserProfile u : userProfileList) {
            b = new BackstageUserProfileDTO(
                    u.getUserId(),
                    u.getUsername(),
                    u.getSecurityLevel(),
                    u.getEmail(),
                    u.getPhone(),
                    u.getGmtCreate(),
                    u.getGmtUpdated());
            backstageUserProfileDTOList.add(b);
        }
        return backstageUserProfileDTOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUsersProfile(List<Integer> idList) {
        userProfileDao.deleteUsersProfile(idList);
        userRegistryDao.deleteUsersRegistry(idList);
        userAddressDao.deleteUsersAddress(idList);
    }

    @Override
    public BackstageUserProfileDTO getUserProfileByUId(Integer uid) {
        UserProfile userProfile = userProfileDao.getUserProfileByUId(uid);
        return new BackstageUserProfileDTO(
                userProfile.getUserId(),
                userProfile.getUsername(),
                userProfile.getSecurityLevel(),
                userProfile.getEmail(),
                userProfile.getPhone(),
                userProfile.getGmtCreate(),
                userProfile.getGmtUpdated()
        );
    }

    @Override
    public Integer getNumOfPages(Integer pageCount) {
        return (userProfileDao.getNumOfUsers() + pageCount - 1) / pageCount;
    }
}
