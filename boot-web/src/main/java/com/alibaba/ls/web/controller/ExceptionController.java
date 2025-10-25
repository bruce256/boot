package com.alibaba.ls.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: LvSheng
 * @date: 2025/10/18
 * @description:
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {
	
	@RequestMapping("/runtime")
	public void index() {
		throw new RuntimeException("error");
//		return "index";
	}
}
