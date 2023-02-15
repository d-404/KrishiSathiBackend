package com.ks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.dao.ProductsDAO;
import com.model.Category;
import com.model.Products;

@RestController
public class ProductsControlller {

	@Autowired
	ProductsDAO prodDAO;

	@GetMapping("/getAllProducts")
	public List<Products> getAllProducts() {
		List<Products> prodList = prodDAO.getAllProducts();
		return prodList;
	}
	
	@PostMapping("/getProductsByCategoryId")
	public List<Products> getProductsByCategoryId(@RequestBody Category category) {
		List<Products> prodList = prodDAO.getProductsByCategoryId(category);
		return prodList;
	}

	@PostMapping("/registerProduct")
	public Products addProduct(@RequestBody Products product) {
		return prodDAO.add(product);
	}

	@DeleteMapping("/deleteProdById/{prodId}")
	public void deleteProdById(@PathVariable("prodId") int prodId) {
		prodDAO.deleteProduct(prodId);
	}

	@PostMapping("/updateProduct")
	public Products updateProduct(@RequestBody Products product) {
		return prodDAO.update(product);
	}

	}
