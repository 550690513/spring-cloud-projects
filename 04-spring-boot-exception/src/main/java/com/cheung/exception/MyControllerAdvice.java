package com.cheung.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheung
 * @ControllerAdvice 表示该类为异常处理类
 */
@ControllerAdvice
public class MyControllerAdvice {

	@ResponseBody
	@ExceptionHandler(value = java.lang.Exception.class)
	public Map<String, Object> myException(Exception exception) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 500);
		map.put("msg", "出错了！");
		return map;
	}

	@ResponseBody
	@ExceptionHandler(value = java.lang.NullPointerException.class)
	public Map<String, Object> myException2(Exception exception) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", -500);
		map.put("msg", "空指针异常！");
		return map;
	}

	@ResponseBody
	@ExceptionHandler(value = com.cheung.exception.ApplicationException.class)
	public Map<String, Object> myException3(Exception exception) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", -800);
		map.put("msg", exception.getMessage());
		return map;
	}


}
