package com.halo.cloud.gateway.task;

import com.halo.cloud.dto.Result;
import com.halo.cloud.forum.api.TopicRestApi;
import com.halo.cloud.util.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/12 21:26
 * @Version 1.0
 */
@Component
public class WebSocketTask {

    private final static Logger log = LoggerFactory.getLogger(WebSocketTask.class);

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final RedisTemplate redisTemplate;
    private final TopicRestApi restApi;

    @Autowired
    public WebSocketTask(SimpMessagingTemplate simpMessagingTemplate, RedisTemplate redisTemplate, TopicRestApi restApi) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.redisTemplate = redisTemplate;
        this.restApi = restApi;
    }

    @Scheduled(cron = "0/3 * * * * ? ")
    public void webSocketTask() {
        log.info("[webSocketTask] start!");
        Set<Integer> uids = redisTemplate.opsForSet().members(Const.Redis.WS_SET_KEY);
        log.info("[webSocketTask] uids:{}", uids);
        if (Objects.isNull(uids)) {
            return;
        }
        for (int uid : uids) {
            Result<Integer> backNumber = restApi.getBackNumber(uid);
            simpMessagingTemplate.convertAndSendToUser(String.valueOf(uid), "/message", backNumber);
        }
    }
}
