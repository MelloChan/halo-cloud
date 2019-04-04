package com.halo.cloud.forum.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/4/4 2:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.halo.cloud.store.api"})
public class HaloForumServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloForumServerApplication.class, args);
    }
}
