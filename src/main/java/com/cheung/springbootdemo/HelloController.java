package com.cheung.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author Cheung
 */
public class HelloController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	public static String sayHello() {
		return "Hello Spring Boot!";
	}


	public static void main(String[] args) {

		String s = sayHello();
		System.out.println(s);


	}


}
