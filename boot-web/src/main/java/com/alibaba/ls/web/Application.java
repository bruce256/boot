package com.alibaba.ls.web;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author 儒尊
 * @date 2018/1/27
 **/
//@EnableGlobalMethodSecurity
@EnableDubbo(scanBasePackages = "com.alibaba.ls.service")
@SpringBootApplication
@MapperScan("com.alibaba.ls.dao.mapper")
@NacosPropertySource(dataId = "boot", autoRefreshed = true)
@EnableCaching
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}


