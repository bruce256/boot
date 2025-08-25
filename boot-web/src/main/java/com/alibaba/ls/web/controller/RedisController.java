package com.alibaba.ls.web.controller;

//import com.alibaba.nacos.api.config.annotation.NacosValue;
import java.io.IOException;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.naming.NamingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LvSheng
 * @date 2021/10/3
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @NacosValue(value = "${owner:lvsheng}", autoRefreshed = true)
    private String owner;

    @NacosValue(value = "${number:1}", autoRefreshed = true)
    private Integer number;

    @Value(value = "${name:lvsheng}")
    private String name;

    //@NacosInjected
    //private NamingService namingService;
    //private PushGateway pushGateway = PushGateway.builder()
    //    .address("localhost:9091") // not needed as localhost:9091 is the default
    //    .job("example")
    //    .build();



    @GetMapping("/get")
    public String get(@RequestParam(value = "key") String key) {
        return stringRedisTemplate.boundValueOps(key).get();
    }


    @GetMapping("/number")
    public Integer getNumber() {
        return null;
    }

/*    @GetMapping("/name")
    public String name() {
        return namingService.getServerStatus();
    }*/
}
