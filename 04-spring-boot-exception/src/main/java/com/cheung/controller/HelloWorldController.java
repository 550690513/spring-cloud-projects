package com.cheung.controller;

import com.cheung.exception.ApplicationException;
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

		/*int a = 1 / 0;
		System.out.println(a);// 模拟算术异常*/

		/*String str = null;
		System.out.println(str.length());// 模拟空指针*/

		// map.put("msg", "Hello World");
		// return map;

		throw new  ApplicationException("程序运行错误！");
	}

}
