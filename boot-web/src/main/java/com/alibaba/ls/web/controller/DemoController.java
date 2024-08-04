package com.alibaba.ls.web.controller;

import com.alibaba.ls.service.DemoService;
import com.alibaba.ls.service.SayHello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @auther 儒尊
 * @date 2018/1/27
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private SayHello sayHello;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/home")
    public String home() {
        log.info(applicationContext.getEnvironment().toString());
        System.out.println(this);
        demoService.hello();
        sayHello.caller();
        return "Hello 吕胜 !";
    }
    
    @RequestMapping("/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(60 * 60 * 1000);
        return "Hello 吕胜 !";
    }
}
