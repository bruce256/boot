package com.alibaba.ls.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 儒尊
 * @date 2018/1/28
 **/
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @PostConstruct
    public void initSentinel() {
        try {
            List<FlowRule> rules = new ArrayList<>();
            FlowRule       rule  = new FlowRule();
            rule.setResource("HelloWorld");
            rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
            // Set limit QPS to 20.
            rule.setCount(20);
            rules.add(rule);
            FlowRuleManager.loadRules(rules);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/test")
    public String index() {

        try (Entry entry = SphU.entry("HelloWorld");) {

            /*您的业务逻辑 - 开始*/
            System.out.println("hello world");
            /*您的业务逻辑 - 结束*/
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
            System.out.println("block!");
            /*流控逻辑处理 - 结束*/
        }
        return "index";
    }
}
