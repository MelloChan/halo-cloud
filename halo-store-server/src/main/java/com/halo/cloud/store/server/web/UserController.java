package com.halo.cloud.store.server.web;

import com.halo.cloud.dto.UserProfileInfoDTO;
import com.halo.cloud.store.api.UserRestApi;
import com.halo.cloud.store.server.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/8 0:10
 * @Version 1.0
 */
@RestController
public class UserController implements UserRestApi {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserProfileInfoDTO getUserProfileInfoByUid(@RequestParam("uid") Integer uid) {
        return userInfoService.getUserProfileInfoByUId(uid);
    }
}
