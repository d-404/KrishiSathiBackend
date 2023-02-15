package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Category;
import com.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
	
	@Query("from Products p where p.productName = :productName")
	Products findByName(@Param("productName") String productName);
	
	@Query("from Products p where p.category = :category")
	List<Products> findwithcategoryId(@Param("category") Category category);

	 
	

}
