package com.alibaba.ls.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LvSheng
 * @date 2021/11/5
 **/
@RestController
@RequestMapping("/thread")
public class ThreadController {
    private AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/oom")
    public void threadOOM() {
        Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("threadOOMThread" + counter.addAndGet(1));
                return thread;
            }
        }).submit(() -> {
            System.out.println("new thread");
        });
    }
}
