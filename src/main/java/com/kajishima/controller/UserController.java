package com.kajishima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kajishima.entity.secondary.User;
import com.kajishima.service.SecondaryUserService;

@RestController
public class UserController {

	@Autowired
	private SecondaryUserService userService;

	@RequestMapping(value="/secondary/users",method=RequestMethod.GET)
	public List<User> list() {
		return userService.list();
	}

}
