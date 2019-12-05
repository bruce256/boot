package com.alibaba.ls.dao.mapper;

import com.alibaba.ls.domain.UserDO;

import java.util.List;

/**
 * @author LvSheng
 * @date 2019/12/5
 **/
public interface UserMapper {
	
	List<UserDO> select();
}
