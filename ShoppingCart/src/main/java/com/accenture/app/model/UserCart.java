package com.accenture.app.model;

import java.util.ArrayList;
import java.util.List;

import com.accenture.app.entity.Cart;

public class UserCart {

	private List<Cart> itemsInCart;
	private Double totalAmount;
	
	public UserCart() {
		this.itemsInCart = new ArrayList<Cart>();
		this.totalAmount = 0.0;
	}
	public List<Cart> getItemsInCart() {
		return itemsInCart;
	}
	public void setItemsInCart(List<Cart> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
