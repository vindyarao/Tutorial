package com.accenture.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
	
	@Id
	private long id;

	@Indexed(unique=true)
	private String productId;

	private String name;
	
	private Double price;
	
	private Double quantity;

	public Product(long id, String productId, String name, Double price, Double quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.setQuantity(quantity);
	}
	
	public Product(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}

