package com.accenture.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.app.entity.Cart;

public interface CartRepository extends MongoRepository<Cart, Long> {

	List<Cart> findByUserId(String userId);
	
	Cart findByUserIdAndProductId(String userId, String productId);
}
