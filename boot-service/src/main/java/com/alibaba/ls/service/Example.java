package com.alibaba.ls.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 儒尊
 * @date 2017/05/22
 */

@EnableEurekaServer
@SpringBootApplication
public class Example {
	
	@RequestMapping("/")
	String home() {
		return "Hello 吕胜 !";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
}
