package com.alibaba.ls.web.controller;

import com.alibaba.ls.service.DemoService;
import com.alibaba.ls.service.SayHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 儒尊
 * @date 2018/1/27
 **/
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private SayHello sayHello;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/home")
    public String home() {
        System.out.println(applicationContext.getEnvironment());
        System.out.println(this);
        demoService.hello();
        sayHello.caller();
        return "Hello 吕胜 !";
    }
}
