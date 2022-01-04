package com.alibaba.ls.service.impl;

import com.alibaba.ls.dao.mapper.UserMapper;
import com.alibaba.ls.domain.UserDO;
import com.alibaba.ls.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LvSheng
 * @date 2021/10/28
 **/
@Service
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private static Logger             logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private        ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key="all.users")
    @Override
    public List<UserDO> select() {
        logger.info("select");
        return userMapper.select();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
