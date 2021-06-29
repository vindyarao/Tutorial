package com.accenture.app.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LoginHistory")
public class LoginHistory {
	
	@Id
	private long id;
	
	private String userId;
	
	private LocalDateTime timeStamp;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public LoginHistory(long id, String userId, LocalDateTime timeStamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.timeStamp = timeStamp;
	}
	
	public LoginHistory() {}

}
