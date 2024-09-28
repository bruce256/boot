package com.alibaba.ls.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  wrk -t12 -c400 -d60s http://localhost:9099/test/test0
 *
 * @auther: LvSheng
 * @date: 2024/9/27
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
	 ThreadLocal<Byte[]> localVariable = new ThreadLocal<Byte[]>();
	
	@RequestMapping(value = "/test0")
	public String test0(HttpServletRequest request) {
		
		localVariable.set(new Byte[1024 * 1024]);// 为线程添加变量
		return "success";
	}
	
}
