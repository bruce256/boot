package com.alibaba.ls.web;

import com.alibaba.ls.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @auther 儒尊
 * @date 2018/4/24
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
	@Autowired
	private DemoService demoService;
	
	@Test
	public void demo() {
		demoService.hello();
	}
}
