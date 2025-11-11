package com.alibaba.ls.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 儒尊
 * @date 2017/05/22
 */
@Slf4j
@Service
public class DemoService {
	
	private AtomicInteger count = new AtomicInteger(0);
	
	@PostConstruct
	public void init() {
		System.out.println("adfasdg");
	}
	
	public void hello() {
		System.out.println("hello");
	}
	
	@Async
	public void dosomething() throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		int idx = count.getAndIncrement();
		log.info("request {}  started", idx);
		Thread.sleep(10 * 1000);
		log.info("request {}  ended", idx);
	}
}
