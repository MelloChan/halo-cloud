package com.halo.cloud.gateway.web.store;

import com.google.common.collect.ImmutableMap;
import com.halo.cloud.gateway.web.BaseController;
import com.halo.cloud.store.api.UserRestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/8 0:07
 * @Version 1.0
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserRestApi userRestApi;

    @GetMapping("/user")
    public Map<String, Object> getUserInfo(){
       return rtnParam(0, ImmutableMap.of("userinfo",userRestApi.getUserProfileInfoByUid(1)));
    }
}
