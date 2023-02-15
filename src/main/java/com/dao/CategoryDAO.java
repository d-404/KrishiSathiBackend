package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Category;


@Service
public class CategoryDAO {
	
	@Autowired
	CategoryRepository categoryRepository;
    
	public List<Category> getAllcategories() {
    	List<Category> categoryList = categoryRepository.findAll();
    	//System.out.println(categoryList);
		return categoryList;
    }

    public Category add(Category category) {
    	return categoryRepository.save(category);
    }

    public void deleteProduct(int categoryId) {
    	categoryRepository.deleteById(categoryId);
    }

    public Category update(Category category) {
    	return categoryRepository.save(category);
    }
    
}
