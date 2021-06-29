package com.accenture.app.service;

import com.accenture.app.model.LoginRequest;
import com.accenture.app.model.LoginResponse;

public interface LoginService {

	LoginResponse loginToApp(LoginRequest request);
	
}
