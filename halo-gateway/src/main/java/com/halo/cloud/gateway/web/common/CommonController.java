package com.halo.cloud.gateway.web.common;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.halo.cloud.gateway.web.BaseController;
import com.halo.cloud.util.UploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Map;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/2 11:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/halo/common")
public class CommonController extends BaseController {

    @PostMapping("/image")
    public Map<String, Object> uploadImage(@RequestBody String image) {
        if (StringUtils.isBlank(image)) {
            return rtnParam(40010, null);
        }
        JsonObject imgJson = (JsonObject) new JsonParser().parse(image);
        byte[] imgByte = Base64.getDecoder().decode(imgJson.get("image").getAsString());
        String imgUrl = UploadUtil.uploadToQiNiuYun(imgByte);
        return rtnParam(0, ImmutableMap.of("imgUrl", imgUrl));
    }
}
