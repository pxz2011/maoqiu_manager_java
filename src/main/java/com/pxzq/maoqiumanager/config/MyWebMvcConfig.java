package com.pxzq.maoqiumanager.config;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/24 09:24:10
 */

import com.pxzq.maoqiumanager.common.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 一定不要忽略此注解
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowCredentials(true) // 是否发送 Cookie
                .allowedOriginPatterns("*") // 支持域
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}) // 支持方法
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] strings = {"/user/login","/user/signup"};
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**") // 设置拦截的路径
                .excludePathPatterns(strings); // 设置不拦截的路径
    }
}
