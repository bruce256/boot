package com.alibaba.ls.service;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther 儒尊
 * @date 2018/2/21
 **/

public class AutowireTestService {
	
	@Autowired
	private DemoService demoService;
	
	public void test() {
		demoService.hello();
	}
}
