package com.cheung.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheung
 */
@RestController
public class HelloWorldController {

	@Value(value = "${hello.msg}")
	private String msg;

	@Value(value = "${author}")
	private String author;

	@Value("${randomInt}")
	private Integer randomInt;


	@RequestMapping("/hello")
	public Map<String, Object> showHelloWorld() {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", this.msg);
		map.put("author", this.author);
		map.put("randomInt", this.randomInt);
		return map;
	}

}
