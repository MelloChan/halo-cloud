package com.halo.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HaloGatewayApplication {
    public static void main(String[] args) {
            SpringApplication.run(HaloGatewayApplication.class,args);
    }
}
