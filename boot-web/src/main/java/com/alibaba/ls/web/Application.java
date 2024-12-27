package com.alibaba.ls.web;

import com.alibaba.ls.service.SayHello;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 儒尊
 * @date 2018/1/27
 **/
//@EnableGlobalMethodSecurity
//@EnableDubbo(scanBasePackages = "com.alibaba.ls.service")
@SpringBootApplication
@MapperScan("com.alibaba.ls.dao.mapper")
@NacosPropertySource(dataId = "camel", autoRefreshed = true)
//@EnableCaching
public class Application {

    @Autowired
    public SayHello sayHello;
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}


