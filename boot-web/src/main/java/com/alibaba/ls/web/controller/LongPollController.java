package com.alibaba.ls.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvSheng
 * @date 2023/10/16
 **/
@Slf4j
@RestController
@RequestMapping("/poll")
public class LongPollController {
	
	private List<DeferredResult<String>> list = new ArrayList<>();
	
	@GetMapping("/async")
	public DeferredResult<String> handleReqDefResult(Model model) {
		log.info("Received async-deferredresult request");
		DeferredResult<String> output = new DeferredResult<>();
		
		output.onTimeout(() -> output.setErrorResult(ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timeout occurred.")));
		output.onError((Throwable t) -> {
			output.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred."));
		});
		
		list.add(output);
		
		log.info("servlet thread freed");
		return output;
	}
	
	@GetMapping("/result")
	public void response(Model model) {
		list.forEach(e -> e.setResult("ok"));
		list.clear();
	}
}
