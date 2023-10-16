package com.alibaba.ls.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

/**
 * @author LvSheng
 * @date 2023/10/16
 **/
@Slf4j
@RestController
@RequestMapping("/poll")
public class LongPollController {
	
	@GetMapping("/async")
	public DeferredResult<ResponseEntity<?>> handleReqDefResult(Model model) {
		log.info("Received async-deferredresult request");
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
		
		output.onTimeout(() -> output.setErrorResult(ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timeout occurred.")));
		output.onError((Throwable t) -> {
			output.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred."));
		});
		
		ForkJoinPool.commonPool().submit(() -> {
			log.info("Processing in separate thread");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
			}
			output.setResult(ResponseEntity.ok("ok"));
		});
		
		log.info("servlet thread freed");
		return output;
	}
}
