package com.halo.cloud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/3 15:55
 * @Version 1.0
 */
public class TimeUtil {

    private TimeUtil() {
    }

    public static String formatDateTime(Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    }
}
