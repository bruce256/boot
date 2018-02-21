package com.alibaba.ls.web.controller;

import com.alibaba.ls.service.AutowireTestService;
import com.alibaba.ls.web.listener.SystemListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 儒尊
 * @date 2018/2/21
 **/
@RestController
public class AutowireTestController {
	
	@RequestMapping("/autowire")
	public void home() {
		AutowireTestService autowireTestService = new AutowireTestService();
		SystemListener.applicationContext.getAutowireCapableBeanFactory().autowireBean(autowireTestService);
		autowireTestService.test();
	}
}
