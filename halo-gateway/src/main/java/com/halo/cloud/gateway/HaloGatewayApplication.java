package com.halo.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages ={"com.halo.cloud"})
public class HaloGatewayApplication {
    public static void main(String[] args) {
            SpringApplication.run(HaloGatewayApplication.class,args);
    }
}
