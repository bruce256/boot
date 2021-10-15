package com.alibaba.ls.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 儒尊
 * @date 2017/05/22
 */

@Service
public class DemoService {

	@PostConstruct
	public void init(){
		System.out.println("adfasdg");
	}

	public void hello() {
		System.out.println("hello");
	}
}
