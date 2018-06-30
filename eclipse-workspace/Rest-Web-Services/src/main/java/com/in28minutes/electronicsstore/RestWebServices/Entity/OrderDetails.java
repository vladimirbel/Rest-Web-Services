package com.in28minutes.electronicsstore.RestWebServices.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

public class OrderDetails {
	
	private int orderDetailsId;
	private int orderId;
	private int productId;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private CustomerOrder customerOrder;
	
	public int getOrderDetailsId() {
		return orderDetailsId;
	}
	
	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
