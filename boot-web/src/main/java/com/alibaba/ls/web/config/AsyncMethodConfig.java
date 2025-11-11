package com.alibaba.ls.web.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import io.sentry.spring.SentryTaskDecorator;

import java.util.concurrent.Executor;

/**
 * @auther: LvSheng
 * @date: 2025/10/28
 * @description:
 */
@Configuration
class AsyncMethodConfig extends AsyncConfigurerSupport {
	
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setTaskDecorator(new SentryTaskDecorator());
		executor.initialize();
		return executor;
	}
}