package com.halo.cloud.gateway.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/12 21:26
 * @Version 1.0
 */
@Component
public class WebSocketTask {
    @Scheduled(cron = "0/3 * * * * ? ")
    public void webSocketTask(){

    }
}
