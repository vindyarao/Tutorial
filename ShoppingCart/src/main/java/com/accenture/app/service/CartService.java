package com.accenture.app.service;

import com.accenture.app.model.AddItemRequest;
import com.accenture.app.model.UserCart;

public interface CartService {

	UserCart getAllItemsInCartForUser(String userId);

	UserCart addItemInCart(AddItemRequest addItemRequest);

	Boolean deleteItemFromCart(String userId, String productId);

}
