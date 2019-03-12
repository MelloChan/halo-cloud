package com.halo.cloud.store.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/6 23:09
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.halo.cloud")
public class HaloStoreServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloStoreServerApplication.class,args);
    }

}
