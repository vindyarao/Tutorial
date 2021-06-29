package com.accenture.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cart")
public class Cart {
	
	@Id
	private long id;
	
	private String userId;
	
	private String productId;
	
	private Double numberOfItems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Double numberOfItems) {
		this.numberOfItems = numberOfItems;
	}


	public Cart(long id, String userId, String productId, Double numberOfItems) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.numberOfItems = numberOfItems;
	}
		
	public Cart() {}
}
