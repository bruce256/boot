package com.alibaba.ls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * @author LvSheng
 * @date 2021/10/3
 **/
@Service
public class RedisManager {

    /*@Autowired
    private JedisPool redisPool;

    public String get(String key) {
        return redisPool.getResource().get(key);
    }*/
}
