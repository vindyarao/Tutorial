package com.accenture.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.entity.User;
import com.accenture.app.model.ChangePasswordRequest;
import com.accenture.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/change-password")
	public Boolean changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
		return userService.changePassword(changePasswordRequest);
	}
	

}
