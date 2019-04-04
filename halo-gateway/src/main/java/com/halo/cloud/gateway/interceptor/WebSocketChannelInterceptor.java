package com.halo.cloud.gateway.interceptor;

import com.halo.cloud.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.util.Objects;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/14 23:12
 * @Version 1.0
 */
public class WebSocketChannelInterceptor implements ChannelInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketChannelInterceptor.class);

    private RedisTemplate redisTemplate;

    public WebSocketChannelInterceptor(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
        // ignore non-STOMP messages like heartbeat messages
        if (sha.getCommand() == null) {
            return;
        }
        int uid = (int) Objects.requireNonNull(sha.getSessionAttributes()).get(Const.WebSocket.WS_USER_ID);
        switch (sha.getCommand()) {
            case CONNECT:
                connect(uid);
                break;
            case CONNECTED:
                break;
            case DISCONNECT:
                disconnect(uid, sha);
                break;
            default:
                break;
        }
    }

    private void connect(int uid) {
        logger.info("[connect] connect success! uid:{}", uid);
        redisTemplate.opsForSet().add(Const.Redis.WS_SET_KEY,uid);
    }

    private void disconnect(int uid, StompHeaderAccessor sha) {
        logger.info("[disconnect] disconnect success! uid:{}", uid);
        Objects.requireNonNull(sha.getSessionAttributes()).remove(Const.WebSocket.WS_USER_ID);
        redisTemplate.opsForSet().remove(Const.Redis.WS_SET_KEY,uid);
    }
}
