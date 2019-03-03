package com.halo.cloud.server.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author MelloChan
 * @date 2018/5/14
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加对象
     *
     * @param key   键
     * @param value 值
     */
    public void add(final String key, final Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 添加对象 加入过期时间
     *
     * @param key     键
     * @param expires 过期时间 单位秒
     * @param value   值
     */
    public void add(final String key, final Long expires, final String value) {
        redisTemplate.opsForValue().set(key, value, expires, TimeUnit.SECONDS);
    }

    /**
     * 删除键值对
     *
     * @param key 键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 修改键值对
     *
     * @param key   键
     * @param value 值
     */
    public void update(final String key, final String value) {
        if (get(key) == null) {
            throw new NullPointerException("数据行不存在, key = " + key);
        }
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取值
     *
     * @param keyId 键
     * @return 值对象
     */
    public Object get(final String keyId) {
        return redisTemplate.opsForValue().get(keyId);
    }
}
