package com.alibaba.ls.web;

import java.util.logging.Filter;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther 儒尊
 * @date 2018/2/2
 **/
@Configuration
@ComponentScan(basePackages = {"com.alibaba.ls"})
public class MyConfiguration {
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean<CommonFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sentinelFilter");
        registration.setOrder(1);

        return registration;
    }
}
