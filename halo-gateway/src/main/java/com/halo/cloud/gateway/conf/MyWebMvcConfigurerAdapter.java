package com.halo.cloud.gateway.conf;

import com.halo.cloud.gateway.interceptor.AdminTokenVerifyInterceptor;
import com.halo.cloud.gateway.interceptor.UserTokenVerifyInterceptor;
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
    public UserTokenVerifyInterceptor userTokenVerifyInterceptor() {
        return new UserTokenVerifyInterceptor();
    }

    @Bean
    public AdminTokenVerifyInterceptor adminTokenVerifyInterceptor(){
        return new AdminTokenVerifyInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userTokenVerifyInterceptor())
                .addPathPatterns("/api/halo/**")
                .excludePathPatterns("/api/halo/store/auth/**")
                .excludePathPatterns("/api/halo/store/register/**")
                .excludePathPatterns("/api/halo/store/item/**")
                .excludePathPatterns("/api/halo/store/category/**")
                .excludePathPatterns("/api/halo/store/cart/**")
                .excludePathPatterns("/api/halo/admin/**")
                .excludePathPatterns("/api/halo/forum")
                .excludePathPatterns("/api/halo/forum/type/**");
        registry.addInterceptor(adminTokenVerifyInterceptor())
                .addPathPatterns("/api/halo/admin/**")
                .excludePathPatterns("/api/halo/admin/login");
    }
}
