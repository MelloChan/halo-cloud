package com.halo.cloud.store.server.service;



import com.halo.cloud.dto.BackstageUserProfileDTO;
import com.halo.cloud.dto.UserProfileInfoDTO;
import com.halo.cloud.dto.UserRegisterInfoDTO;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/26
 */
public interface UserInfoService {
    /**
     * 通过手机号查找用户id
     *
     * @param phone 用户手机号
     * @return 用户id
     */
    Integer getIdByPhone(String phone);

    /**
     * 通过用户名查找id
     *
     * @param username 用户名
     * @return 个人信息id
     */
    Integer getIdByUsername(String username);

    /**
     * 通过用户邮箱查找id
     *
     * @param email 用户邮箱
     * @return 个人信息id
     */
    Integer getIdByEmail(String email);

    /**
     * 验证用户手机号与密码
     *
     * @param phone    用户手机号
     * @param password 用户密码
     * @return 用户id
     */
    Integer verifyLoginInfo(String phone, String password);


    /**
     * 通过用户Id获取用户信息
     *
     * @param userId 用户注册时赋值的唯一id
     * @return 用户个人信息
     */
    UserProfileInfoDTO getUserProfileInfoByUId(Integer userId);

    /**
     * 通过用户id获取用户哈币数值
     *
     * @param userId 用户id
     * @return 哈币
     */
    Integer getHaloCoinByUId(Integer userId);

    /**
     * 验证用户密码
     *
     * @param pwd    用户密码
     * @param userId 用户id
     * @return 验证成功与否
     */
    boolean verifyPwd(String pwd, Integer userId);

    /**
     * 用户注册
     *
     * @param userRegisterInfoDTO 用户注册信息 手机号+密码+用户名
     * @return 用户id
     */
    Integer insertUserInfo(UserRegisterInfoDTO userRegisterInfoDTO);

    /**
     * 更新哈币
     *
     * @param number 更新的数值
     * @param userId 用户ID
     * @return 返回影响条数
     */
    boolean updateCoinByUId(Integer number, Integer userId);

    /**
     * 更新头像
     *
     * @param part   头像图片资源
     * @param userId 用户id
     * @return 头像外链
     * @throws IOException 图片异常
     */
    String updateAvatarByUId(Part part, Integer userId) throws IOException;

    /**
     * 更新密码
     *
     * @param newPwd 新密码
     * @param userId 用户id
     * @return 更新成功否
     */
    boolean updatePwdByUId(String newPwd, Integer userId);

    /**
     * 更新邮箱
     *
     * @param email  用户邮箱
     * @param userId 用户id
     * @return 成功与否
     */
    boolean updateEmailByUId(String email, Integer userId);

    /**
     * 更新手机号
     *
     * @param phone  用户手机号
     * @param userId 用户id
     * @return 成功与否
     */
    boolean updatePhoneByUId(String phone, Integer userId);

    /**
     * 通过用户手机号更新密码
     *
     * @param pwd   用户密码
     * @param phone 用户手机号
     */
    boolean updatePwdByPhone(String pwd, String phone);

    /**
     * 获取所有用户的信息
     */
    List<BackstageUserProfileDTO> getUsersProfile(Integer pageIndex, Integer pageCount);

    /**
     * 后台删除指定用户信息
     *
     * @param idList 用户id列表
     */
    void deleteUsersProfile(List<Integer> idList);

    /**
     * 获取指定用户的信息
     *
     * @param uid 用户id
     * @return 返回指定用户的信息
     */
    BackstageUserProfileDTO getUserProfileByUId(Integer uid);

    /**
     * @param pageCount 一页显示数据量
     * @return 返回10个/页的页数
     */
    Integer getNumOfPages(Integer pageCount);
}
