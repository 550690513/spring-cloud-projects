package com.cheung.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheung
 */
@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public Map<String, Object> showHelloWorld() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "Hello World");
		return map;
	}

}
