package com.accenture.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.app.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Long> {

	Product findByProductId(String productId);
}
