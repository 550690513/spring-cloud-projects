package com.cheung.controller;

import com.cheung.pojo.User;
import com.cheung.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheung
 */
@RestController()
@RequestMapping(value = "/consumer")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public List<User> getUsers() {
		return this.userService.getAll();
	}
}
