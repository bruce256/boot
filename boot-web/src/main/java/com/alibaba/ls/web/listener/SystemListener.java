package com.alibaba.ls.web.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 儒尊
 * @date 2018/2/21
 **/
@Component
public class SystemListener implements ApplicationContextAware {
	
	public static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SystemListener.applicationContext = applicationContext;
	}
}
