package com.halo.cloud.gateway.conf;

import com.halo.cloud.gateway.interceptor.SessionVerifyInterceptor;
import com.halo.cloud.gateway.interceptor.TokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MelloChan
 * @date 2018/5/1
 */
@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Bean
    public TokenVerifyInterceptor tokenVerifyInterceptor() {
        return new TokenVerifyInterceptor();
    }

    @Bean
    public SessionVerifyInterceptor sessionVerifyInterceptor() {
        return new SessionVerifyInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenVerifyInterceptor())
                .addPathPatterns("/api/halo/**")
                .excludePathPatterns("/api/halo/auths/**")
                .excludePathPatterns("/api/halo/registers/**")
                .excludePathPatterns("/api/halo/items/**")
                .excludePathPatterns("/api/halo/categorys/**")
                .excludePathPatterns("/api/halo/carts/**")
                .excludePathPatterns("/api/halo/backstage/**");
        registry.addInterceptor(sessionVerifyInterceptor())
                .addPathPatterns("/api/halo/backstage/**")
                .excludePathPatterns("/api/halo/backstage/admins/**");
    }
}
