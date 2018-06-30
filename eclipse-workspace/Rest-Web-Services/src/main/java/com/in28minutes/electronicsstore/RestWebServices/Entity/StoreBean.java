package com.in28minutes.electronicsstore.RestWebServices.Entity;

public class StoreBean {
	private String storeName;
	
	public StoreBean(String  name) {
		storeName = name;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String name) {
		storeName = name;
	}
}
