package com.example.LibraryAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryAPI.dao.UserDao;
import com.example.LibraryAPI.models.User;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/create/student")
	public User createStudent(@RequestBody User user) {
		user.setRole("ROLE_STUDENT");
		return userDao.save(user);
	}
	
	
}
