package com.alibaba.ls.web.controller;

import com.alibaba.ls.service.DemoService;
import com.alibaba.ls.service.SayHello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther 儒尊
 * @date 2018/1/27
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	@Autowired
	private SayHello    sayHello;
	
	private AtomicInteger count = new AtomicInteger(0);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@RequestMapping("/home")
	public String home() {
		log.info(applicationContext.getEnvironment().toString());
		System.out.println(this);
		demoService.hello();
		sayHello.caller();
		return "Hello 吕胜 !";
	}
	
	@RequestMapping("/sleep")
	public String sleep() throws InterruptedException {
		int idx = count.getAndIncrement();
		log.info("request {}  started", idx);
		Thread.sleep(10 * 1000);
		log.info("request {}  ended", idx);
		return "Hello 吕胜 !";
	}
}
