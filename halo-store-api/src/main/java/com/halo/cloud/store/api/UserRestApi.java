package com.halo.cloud.store.api;

import com.halo.cloud.dto.store.UserProfileInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("HALO-STORE-SERVER")
public interface UserRestApi {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    UserProfileInfoDTO getUserProfileInfoByUid(@RequestParam("uid")Integer uid);
}
