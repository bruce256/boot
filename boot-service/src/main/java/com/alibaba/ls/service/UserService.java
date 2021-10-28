package com.alibaba.ls.service;

import com.alibaba.ls.domain.UserDO;

import java.util.List;

/**
 * @author LvSheng
 * @date 2021/10/28
 **/
public interface UserService {

    List<UserDO> select();
}
