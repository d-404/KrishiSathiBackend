package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id @GeneratedValue
	private int categoryId;

	@Column(name = "categoryName", unique = true)
	private String categoryName;
	private String categoryDescription;
	private String image;

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Products> product = new ArrayList<Products>();

	public Category() {
		super();
		
	}

	public Category(int categoryId, String categoryName, String categoryDescription, String image,
			List<Products> product) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.image = image;
		this.product = product;
	}
	
	public Category(int categoryId, String categoryName, String categoryDescription, String image) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.image = image;
	}

	public int getcategoryId() {
		return categoryId;
	}
	public void setcategoryId(int categoryid) {
		this.categoryId = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", imgPath=" + image + "]";
	}
	
}
