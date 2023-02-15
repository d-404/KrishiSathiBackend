package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;
import com.model.Products;

@Service
public class ProductsDAO {
	
	@Autowired
	ProductsRepository productRepository;

	public List<Products> getAllProducts() {

		List<Products> productList = productRepository.findAll();
		return productList;

	}

	public Products add(Products product) {
		return productRepository.save(product);
	}

	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}
	
	public Products update(Products product) {
		return productRepository.save(product);
	}

	public List<Products> getProductsByCategoryId(Category categoryId) {
		List<Products> productList =  (List<Products>) productRepository.findwithcategoryId(categoryId);
		return productList;
		
	}

}