package com.halo.cloud.gateway.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/8 0:03
 * @Version 1.0
 */
@Controller
public class BaseController {
    @Autowired
    private ImmutableMap<String, String> errorCodeMap;

    /**
     * 接口数据返回
     *
     * @param errorCode 转态码
     * @param data      数据
     * @return 参数数据
     */
    protected Map<String, Object> rtnParam(Integer errorCode, Object data) {
        //正常业务返回
        if (0 == errorCode) {
            return ImmutableMap.of("errorCode", errorCode, "data", (data == null) ? new Object() : data);
        } else {
            return ImmutableMap.of("errorCode", errorCode, "msg", errorCodeMap.get(String.valueOf(errorCode)));
        }
    }
}
