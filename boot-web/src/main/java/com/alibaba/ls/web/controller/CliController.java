package com.alibaba.ls.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.ls.dao.mapper.UserMapper;
import com.alibaba.ls.domain.UserDO;
import com.alibaba.ls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/4/4
 **/


/*************************************************
 * 测试用cli运行： spring run CliController.java
 *************************************************/
@RestController
public class CliController {

    @Autowired
    private UserService userService;

    @RequestMapping("/client")
    public String home() {
        List<UserDO> users = userService.select();
        return JSONArray.toJSONString(users);
    }
}
