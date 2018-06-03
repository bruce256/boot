package com.alibaba.ls.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 儒尊
 * @date 2018/4/4
 **/
/*************************************************
 * 测试用cli运行： spring run CliController.java
 *************************************************/
@RestController
public class CliController {
	
	@RequestMapping("/client")
	public String home() {
		return "Hello World!";
	}
}
