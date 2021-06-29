package com.accenture.app.service;

import java.util.List;

import com.accenture.app.entity.User;
import com.accenture.app.model.ChangePasswordRequest;

public interface UserService {
	
	List<User> getAllUsers();
	
	Boolean changePassword(ChangePasswordRequest changePasswordRequest);
	
}
