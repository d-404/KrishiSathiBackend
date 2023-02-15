package com.ks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CategoryDAO;
import com.model.Category;

@RestController
public class CategoryController {

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/getAllCategories")
	public List<Category> getAllCategories() {
		List<Category> categoryList = categoryDAO.getAllcategories();
		return categoryList;
	}

    @PostMapping("/registerCategory")
	public Category addCategory(@RequestBody Category category) {
		return categoryDAO.add(category);
	}

	@DeleteMapping("/deleteCategoryById/{categoryId}")
	public void deleteCategoryById(@PathVariable("categoryId") int categoryId) {
		categoryDAO.deleteProduct(categoryId);
	}

	@PostMapping("/updateCategory")
	public Category updateProduct(@RequestBody Category category) {
		return categoryDAO.update(category);
	}

}
