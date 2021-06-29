package com.accenture.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.model.LoginRequest;
import com.accenture.app.model.LoginResponse;
import com.accenture.app.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping
	public LoginResponse loginToApp(@RequestBody LoginRequest loginRequest) {
		return loginService.loginToApp(loginRequest);
	}
	
	
}
