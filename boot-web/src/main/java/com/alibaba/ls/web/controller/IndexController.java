package com.alibaba.ls.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther 儒尊
 * @date 2018/1/28
 **/
@Controller
@RequestMapping("/index")
public class IndexController {
	
	
	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("name", "ruzun");
		return "index";
	}
}
