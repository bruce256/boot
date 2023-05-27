package com.alibaba.ls.web.utils;

import com.google.common.collect.Maps;
import com.mysql.cj.log.LogFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author LvSheng
 * @date 2021/10/29
 **/
@Slf4j
//@Component
public class


TimeCostBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    Logger            logger  = LoggerFactory.getLogger("BeanTimeCost");
    Map<String, Long> costMap = Maps.newConcurrentMap();

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        costMap.put(beanName, System.currentTimeMillis());
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        long start = costMap.get(beanName);
        long cost  = System.currentTimeMillis() - start;
        if (cost > 0) {
            costMap.put(beanName, cost);
            logger.info("class: {}\nbean: {}\n time cost: {} ms", bean.getClass().getName(), beanName, cost);
        }
        return bean;
    }
}
