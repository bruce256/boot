package com.alibaba.ls.service;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author 儒尊
 * @date 2017/05/06
 */
@Component
public class SayHello {

	@Retryable(maxAttempts = 4)
	public void callee() {
		System.out.println("hello everyone");
		throw new NullPointerException();
	}
	
	public void caller() {
		this.callee();
	}
}
