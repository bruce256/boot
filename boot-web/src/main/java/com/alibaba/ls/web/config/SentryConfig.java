package com.alibaba.ls.web.config;

import org.springframework.stereotype.Component;
import io.sentry.protocol.User;
import io.sentry.spring.SentryUserProvider;

/**
 * @auther: LvSheng
 * @date: 2025/10/27
 * @description:
 */
@Component
public class SentryConfig implements SentryUserProvider {
	
	public User provideUser() {
		User user = new User();
		user.setId("7570488");
		user.setUsername("bruce");
		// ... set user information
		return user;
	}
}
