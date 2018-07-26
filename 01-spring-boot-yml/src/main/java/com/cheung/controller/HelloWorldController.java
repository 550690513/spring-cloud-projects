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

	@Value(value = "${hello.msg2}")
	private String msg2;

	@Value(value = "${author}")
	private String author;

	@Value("${randomInt}")
	private Integer randomInt;


	@RequestMapping("/hello")
	public Map<String, Object> showHelloWorld() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", this.msg);
		map.put("msg2", this.msg2);
		map.put("author", this.author);
		map.put("randomInt", this.randomInt);
		return map;
	}

}
