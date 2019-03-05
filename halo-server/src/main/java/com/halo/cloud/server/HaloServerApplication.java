package com.halo.cloud.server;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient
public class HaloServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloServerApplication.class,args);
    }

    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
