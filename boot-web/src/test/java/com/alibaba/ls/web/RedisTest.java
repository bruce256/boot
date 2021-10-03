package com.alibaba.ls.web;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author LvSheng
 * @date 2021/10/3
 **/
public class RedisTest {
    @Test
    public void redisValue() {
        Jedis        jedis  = new Jedis("localhost", 6379);
        Random       random = new Random();
        StringBuffer sb     = new StringBuffer();
        for (int i = 0; i < 1024 * 1024; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        jedis.set("bigkey", sb.toString());
    }
}
