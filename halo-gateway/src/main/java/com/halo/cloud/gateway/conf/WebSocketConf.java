package com.halo.cloud.gateway.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/12 21:07
 * @Version 1.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConf implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/user");
        // P2P推送
        registry.setUserDestinationPrefix("/api/ws/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // ws连接端点
        registry.addEndpoint("/api/ws");
    }
}
