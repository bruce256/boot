package com.alibaba.ls.service.impl;

import com.alibaba.ls.dao.mapper.UserMapper;
import com.alibaba.ls.domain.UserDO;
import com.alibaba.ls.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDO> select() {
        return userMapper.select();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
