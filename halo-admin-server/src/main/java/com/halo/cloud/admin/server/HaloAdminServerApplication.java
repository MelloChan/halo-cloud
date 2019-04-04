package com.halo.cloud.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/6 23:12
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.halo.cloud")
@EnableDiscoveryClient
public class HaloAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloAdminServerApplication.class,args);
    }
}
