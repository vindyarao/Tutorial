package com.accenture.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.app.entity.User;

public interface UserRepository extends MongoRepository<User, Long>{

	User findByUserId(String userId);
	
}
