package com.alibaba.ls.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * @auther 儒尊
 * @date 2018/1/27
 **/
//@EnableGlobalMethodSecurity
@SpringBootApplication
@MapperScan("com.alibaba.ls.dao.mapper")
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}


