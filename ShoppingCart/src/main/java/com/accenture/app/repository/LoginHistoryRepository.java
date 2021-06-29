package com.accenture.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.app.entity.LoginHistory;

public interface LoginHistoryRepository extends MongoRepository<LoginHistory, Long>{

}
