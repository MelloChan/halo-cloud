package com.halo.cloud.gateway.interceptor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/14 23:12
 * @Version 1.0
 */
public class WebSocketChannelInterceptor implements ChannelInterceptor {

    private RedisTemplate redisTemplate;

    public WebSocketChannelInterceptor(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
        // ignore non-STOMP messages like heartbeat messages
        if(sha.getCommand() == null) {
            return;
        }
        switch(sha.getCommand()) {
            case CONNECT:
                connect();
                break;
            case CONNECTED:
                break;
            case DISCONNECT:
                disconnect();
                break;
            default:
                break;
        }
    }

    private void connect(){

    }

    private void disconnect(){

    }
}
