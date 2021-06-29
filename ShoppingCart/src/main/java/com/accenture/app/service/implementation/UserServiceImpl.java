package com.accenture.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.accenture.app.entity.User;
import com.accenture.app.model.ChangePasswordRequest;
import com.accenture.app.repository.UserRepository;
import com.accenture.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Boolean changePassword(ChangePasswordRequest changePasswordRequest) {
		
		User user= userRepository.findByUserId(changePasswordRequest.getUserId());
		
		if(null == user) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Not Found");
		}
		
		if(!user.getPassword().equals(changePasswordRequest.getCurrentPassword())) {
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Bad Password");
		}
		
		user.setPassword(changePasswordRequest.getNewPassword());
		user = userRepository.save(user);
		
		return user.getPassword().equals(changePasswordRequest.getNewPassword());
	}

}
