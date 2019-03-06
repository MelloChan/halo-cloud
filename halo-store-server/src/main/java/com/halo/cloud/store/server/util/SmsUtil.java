package com.halo.cloud.store.server.util;

import com.halo.cloud.store.server.conf.Ucpaas;
import com.halo.cloud.util.GsonUtil;
import com.halo.cloud.util.HttpUtil;

/**
 * @author MelloChan
 * @date 2018/5/25
 * 短信发送工具
 */
public class SmsUtil {
    private SmsUtil() {
    }

    /**
     * 短信单发验证
     *
     * @param ucpaas 云之讯配置类
     * @return 结果json
     */
    public static String sendSms(Ucpaas ucpaas) {
        String url = ucpaas.getUrl();
        String json = GsonUtil.toJsonString(ucpaas);
        return HttpUtil.getInstance().requestPostByJson(url, json);
    }
}
