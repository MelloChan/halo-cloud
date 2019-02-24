package com.halo.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HaloServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HaloServerApplication.class,args);
    }
}
