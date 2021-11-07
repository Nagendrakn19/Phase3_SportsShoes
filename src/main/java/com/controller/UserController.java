package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.User;
import com.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	
	//http://localhost:9191/users
	@GetMapping("/users")
	public List<User> getSingedUpUsers()
	{
		return userService.getSingedUpUsers();
	}
	
	//http://localhost:9191/findUser/1
	@RequestMapping(value="findUser/{id}",method = RequestMethod.GET)
	public User findUserRecordById(@PathVariable("id") int id)
	{
		return userService.findUserById(id);
	}
}
