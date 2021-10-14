package com.alibaba.ls.web.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @NacosValue(value = "${owner}", autoRefreshed = true)
    private String owner;

    @NacosInjected
    private NamingService namingService;

    @GetMapping("/get")
    public String get(@RequestParam(value = "key") String key) {
        return stringRedisTemplate.boundValueOps(key).get();
    }

    @GetMapping("/owner")
    public String getOwner() {
        return owner;
    }

    @GetMapping("/name")
    public String name() {
        return namingService.getServerStatus();
    }
}
