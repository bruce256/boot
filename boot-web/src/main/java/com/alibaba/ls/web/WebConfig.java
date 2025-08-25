package com.alibaba.ls.web;

import com.alibaba.ls.web.websocket.EchoChannel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @auther 儒尊
 * @date 2018/2/7
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/*@Bean
	public ServletListenerRegistrationBean<SystemListener> testListenerRegistration() {
		return new ServletListenerRegistrationBean<>(new SystemListener());
	}*/
	
	@Bean
	public ServerEndpointExporter serverEndpointExporter (){
		
		ServerEndpointExporter exporter = new ServerEndpointExporter();
		
		// 手动注册 WebSocket 端点
		exporter.setAnnotatedEndpointClasses(EchoChannel.class);
		
		return exporter;
	}
}
