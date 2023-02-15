package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrdersHistory {
	
	@Id
	private int orderNumber;
	
	private int userId;
	private int productId;
	private int qty;
	private String productDescription;
	private double productPrict;
	private double totalPrice;
	private String imagePath;
	
	public OrdersHistory() {
		super();
		
	}
	public OrdersHistory(int orderNumber, int userId, int productId, int qty, String productDescription,
			double productPrict, double totalPrice, String imagePath) {
		super();
		this.orderNumber = orderNumber;
		this.userId = userId;
		this.productId = productId;
		this.qty = qty;
		this.productDescription = productDescription;
		this.productPrict = productPrict;
		this.totalPrice = totalPrice;
		this.imagePath = imagePath;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getProductPrict() {
		return productPrict;
	}
	public void setProductPrict(double productPrict) {
		this.productPrict = productPrict;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public String toString() {
		return "OrdersHistory [orderNumber=" + orderNumber + ", userId=" + userId + ", productId=" + productId
				+ ", qty=" + qty + ", productDescription=" + productDescription + ", productPrict=" + productPrict
				+ ", totalPrice=" + totalPrice + ", imagePath=" + imagePath + "]";
	}
}
