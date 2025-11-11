package com.alibaba.ls.web.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.sentry.spring.SentryTaskDecorator;

/**
 * @auther: LvSheng
 * @date: 2025/10/28
 * @description:
 */
@Configuration
class AsyncWebMvcConfiguration implements WebMvcConfigurer {
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setTaskExecutor(asyncExecutor());
	}
	
	private AsyncTaskExecutor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setTaskDecorator(new SentryTaskDecorator());
		executor.initialize();
		return executor;
	}
}
