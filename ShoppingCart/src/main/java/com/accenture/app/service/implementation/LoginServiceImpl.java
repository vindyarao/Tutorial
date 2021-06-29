package com.accenture.app.service.implementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.accenture.app.entity.LoginHistory;
import com.accenture.app.entity.User;
import com.accenture.app.model.LoginRequest;
import com.accenture.app.model.LoginResponse;
import com.accenture.app.repository.LoginHistoryRepository;
import com.accenture.app.repository.UserRepository;
import com.accenture.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	LoginHistoryRepository loginHistoryRepository;
	
	@Override
	public LoginResponse loginToApp(LoginRequest request) {
		User user= userRepository.findByUserId(request.getUserId());
		
		if(null == user) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Not Found");
		}
		
		if(!user.getPassword().equals(request.getPassword())) {
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Bad Password");
		}
		
		loginHistoryRepository.save(new LoginHistory(loginHistoryRepository.findAll().size() + 1, request.getUserId(), LocalDateTime.now()));
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setLoggedIn(true);
		loginResponse.setRole(user.getRole());
		loginResponse.setUserId(user.getUserId());
		loginResponse.setUserName(user.getName());
		return loginResponse;
	}

}
