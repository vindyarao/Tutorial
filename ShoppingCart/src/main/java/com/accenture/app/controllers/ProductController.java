package com.accenture.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.app.entity.Product;
import com.accenture.app.model.ProductRequest;
import com.accenture.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") String productId) {
		return productService.getProduct(productId);
	}
	
	@PostMapping
	public Product addProduct(@RequestBody ProductRequest addProductRequest) {
		return productService.addProduct(addProductRequest);
	}
	
	@PutMapping("/{productId}")
	public Product editProduct(@RequestBody ProductRequest addProductRequest) {
		return productService.editProduct(addProductRequest);
	}
	
	@DeleteMapping("/{userId}/{productId}")
	public Boolean deleteProduct(@PathVariable("userId") String userId,
			@PathVariable("productId") String productId) {
		return productService.deleteProduct(userId, productId);
	}
}
