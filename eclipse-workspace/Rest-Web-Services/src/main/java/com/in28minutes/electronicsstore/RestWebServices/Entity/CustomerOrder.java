package com.in28minutes.electronicsstore.RestWebServices.Entity;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CustomerOrder {
	private int orderId;
	private int customerId;
	private Date orderDate;
	private float total;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}
