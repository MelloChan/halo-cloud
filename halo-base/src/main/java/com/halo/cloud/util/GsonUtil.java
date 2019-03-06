package com.halo.cloud.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

/**
 * @author MelloChan
 * @date 2018/5/16
 */
public class GsonUtil {
    private static Gson gson;

    private GsonUtil() {
    }

    static {
        gson = new Gson();
    }

    public static String toJsonString(Object object) {
        return object == null ? null : gson.toJson(object);
    }

    public static Object jsonToObject(String jStr, Class clazz) {
        Object o = null;
        if (!StringUtils.isNotBlank(jStr)) {
            o = gson.fromJson(jStr, clazz);
        }
        return o;
    }
}
