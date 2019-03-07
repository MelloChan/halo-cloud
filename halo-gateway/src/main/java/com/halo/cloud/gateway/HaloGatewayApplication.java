package com.halo.cloud.gateway;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.halo.cloud"})
public class HaloGatewayApplication {
    private static final Logger log = LoggerFactory.getLogger(HaloGatewayApplication.class);

    private static ImmutableMap<String, String> errorCodeMap = null;

    public static void main(String[] args) {
        SpringApplication.run(HaloGatewayApplication.class, args);
    }

    static {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("error_code.properties");
            errorCodeMap = Maps.fromProperties(properties);
        } catch (IOException e) {
            log.error("static errorCodeMap error:{}", e, e.getMessage());
        }
    }

    @Bean
    public ImmutableMap<String, String> errorCodeMap() {
        return errorCodeMap;
    }
}
