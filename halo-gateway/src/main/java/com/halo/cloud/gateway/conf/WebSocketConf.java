package com.halo.cloud.gateway.conf;

import com.halo.cloud.gateway.interceptor.WebSocketChannelInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.config.ChannelRegistration;
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

    private final RedisTemplate redisTemplate;

    @Autowired
    public WebSocketConf(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

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

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(webSocketChannelInterceptor());
    }

    @Bean
    public WebSocketChannelInterceptor webSocketChannelInterceptor(){
        return new WebSocketChannelInterceptor(redisTemplate);
    }


}
