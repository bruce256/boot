package com.alibaba.ls.web;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther 儒尊
 * @date 2018/1/27
 **/
//@EnableGlobalMethodSecurity
@SpringBootApplication
@MapperScan("com.alibaba.ls.dao.mapper")
@NacosPropertySource(dataId = "boot", autoRefreshed = true)
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}


