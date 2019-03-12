package com.halo.cloud.forum.server;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/6 23:21
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.halo.cloud")
public class HaloForumServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloForumServerApplication.class,args);
    }

    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}

