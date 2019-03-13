package com.halo.cloud.gateway.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/12 21:26
 * @Version 1.0
 */
@Component
public class WebSocketTask {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(cron = "0/3 * * * * ? ")
    public void webSocketTask(){
        simpMessagingTemplate.convertAndSendToUser("mello","/message","测试");
    }
}
