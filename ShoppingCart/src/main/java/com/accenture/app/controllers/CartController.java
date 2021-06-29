package com.accenture.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.model.AddItemRequest;
import com.accenture.app.model.UserCart;
import com.accenture.app.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/{userId}")
	public UserCart getAllItemsInCartForUser(@PathVariable("userId") String userId) {
		return cartService.getAllItemsInCartForUser(userId);
	}
	
	@PostMapping
	public UserCart addItemInCart(@RequestBody AddItemRequest addItemRequest) {
		return cartService.addItemInCart(addItemRequest);
	}
	
	@DeleteMapping("/{userId}/{productId}")
	public Boolean deleteItemFromCart(@PathVariable("userId") String userId,
			@PathVariable("productId") String productId) {
		return cartService.deleteItemFromCart(userId, productId);
	}
}
