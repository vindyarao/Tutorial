package com.accenture.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.accenture.app.entity.Cart;
import com.accenture.app.entity.Product;
import com.accenture.app.model.AddItemRequest;
import com.accenture.app.model.UserCart;
import com.accenture.app.repository.CartRepository;
import com.accenture.app.repository.ProductRepository;
import com.accenture.app.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public UserCart getAllItemsInCartForUser(String userId) {
		List<Cart> carts = cartRepository.findByUserId(userId);
		UserCart userCart = new UserCart();
		userCart.setItemsInCart(carts);
		carts.forEach(cart -> {
			Product product = productRepository.findByProductId(cart.getProductId());
			userCart.setTotalAmount(userCart.getTotalAmount() + cart.getNumberOfItems()*product.getPrice());
		});
		
		return userCart;
	}

	@Override
	public UserCart addItemInCart(AddItemRequest addItemRequest) {
		Product product = productRepository.findByProductId(addItemRequest.getProductId());
		if(null == product) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product does not exist");
		}
		
		if(product.getQuantity() < addItemRequest.getQuantity()) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product supply is less");
		}
		
		Cart cart = new Cart(cartRepository.findAll().size() + 1,
				 addItemRequest.getUserId(),
				 addItemRequest.getProductId(), 
				 addItemRequest.getQuantity());
		cart = cartRepository.save(cart);
		
		product.setQuantity(product.getQuantity() - addItemRequest.getQuantity());
		product = productRepository.save(product);
		
		List<Cart> carts = cartRepository.findByUserId(addItemRequest.getUserId());
		UserCart userCart = new UserCart();
		userCart.setItemsInCart(carts);
		carts.forEach(c -> {
			Product p = productRepository.findByProductId(c.getProductId());
			userCart.setTotalAmount(userCart.getTotalAmount() + c.getNumberOfItems()*p.getPrice());
		});
		
		return userCart;
	}

	@Override
	public Boolean deleteItemFromCart(String userId, String productId) {
		Cart cart = cartRepository.findByUserIdAndProductId(userId, productId);
		if(null == cart) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Item not in cart");
		}
		cartRepository.delete(cart);
		Product product = productRepository.findByProductId(productId);
		product.setQuantity(product.getQuantity() + cart.getNumberOfItems());
		product = productRepository.save(product);
		
		return Boolean.TRUE;
	}

}
