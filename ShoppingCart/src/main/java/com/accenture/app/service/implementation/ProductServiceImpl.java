package com.accenture.app.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.accenture.app.entity.Product;
import com.accenture.app.entity.Role;
import com.accenture.app.entity.User;
import com.accenture.app.model.ProductRequest;
import com.accenture.app.repository.ProductRepository;
import com.accenture.app.repository.UserRepository;
import com.accenture.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(String productId) {
		return productRepository.findByProductId(productId);
	}

	@Override
	public Product addProduct(ProductRequest addProductRequest) {
		User user = userRepository.findByUserId(addProductRequest.getUserId());

		if(null == user || !Role.ADMIN.equals(user.getRole())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Not Found or Not an ADMIN");
		}

		Product product = productRepository.findByProductId(addProductRequest.getProductId());
		if(null == product) {
			product = new Product(productRepository.findAll().size() + 1, 
					addProductRequest.getProductId(),
					addProductRequest.getName(),
					addProductRequest.getPrice(),
					addProductRequest.getQuantity());
		}

		else if(product.getProductId().equals(addProductRequest.getProductId())) {
			product.setName(addProductRequest.getName());
			product.setPrice(addProductRequest.getPrice());
			product.setQuantity(addProductRequest.getQuantity());
		}
		product = productRepository.save(product);
		return product;
	}

	@Override
	public Product editProduct(ProductRequest addProductRequest) {
		User user = userRepository.findByUserId(addProductRequest.getUserId());

		if(null == user || !Role.ADMIN.equals(user.getRole())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Not Found or Not an ADMIN");
		}

		Product product = productRepository.findByProductId(addProductRequest.getProductId());
		if(null == product) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product does not exist");
		}
		
		product.setName(addProductRequest.getName());
		product.setPrice(addProductRequest.getPrice());
		product.setQuantity(addProductRequest.getQuantity());
		
		product = productRepository.save(product);
		return product;
	}

	@Override
	public Boolean deleteProduct(String userId, String productId) {
		User user = userRepository.findByUserId(userId);

		if(null == user || !Role.ADMIN.equals(user.getRole())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "User Not Found or Not an ADMIN");
		}
		
		Product product = productRepository.findByProductId(productId);
		if(null == product) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Product does not exist");
		}
		productRepository.delete(product);
		return Boolean.TRUE;
	}

}
