package com.alibaba.ls.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 儒尊
 * @date 2018/1/27
 **/
@RestController
public class DemoController {
	@RequestMapping("/home")
	public String home() {
		return "Hello 吕胜 !";
	}
}
