package com.accenture.app.service;

import java.util.List;

import com.accenture.app.entity.Product;
import com.accenture.app.model.ProductRequest;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProduct(String productId);

	Product addProduct(ProductRequest addProductRequest);

	Product editProduct(ProductRequest addProductRequest);

	Boolean deleteProduct(String userId, String productId);

}
