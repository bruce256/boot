package com.alibaba.ls.web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * wrk -t12 -c400 -d60s http://localhost:9099/test/test0
 *
 * @auther: LvSheng
 * @date: 2024/9/27
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/prometheus")
public class PrometheusController {

    @Autowired
    private MeterRegistry registry;

    private Counter visitCounter;

    @PostConstruct
    private void init() {
        visitCounter = registry.counter("visit.count");
    }

    @RequestMapping(value = "/test0")
    public String test0(HttpServletRequest request) {

        visitCounter.increment();
        return "success";
    }

    @RequestMapping(value = "/test1")
    public String test1(HttpServletRequest request) {

        visitCounter.increment();
        return "success";
    }

}
