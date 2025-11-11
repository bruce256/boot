package com.alibaba.ls.web.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LvSheng
 * @date 2022/9/17
 **/

@Slf4j
@RestControllerAdvice(basePackages = "com.alibaba.ls.web")
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public void handler(Exception e) {
//		Sentry.captureException(e);
		log.error(e.getMessage(), e);
	}
}
