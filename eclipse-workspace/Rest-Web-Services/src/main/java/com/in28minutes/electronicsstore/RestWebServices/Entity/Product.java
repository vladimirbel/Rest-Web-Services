package com.in28minutes.electronicsstore.RestWebServices.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@NamedQuery(name="find_all_products", query="select p from Product p")
@ApiModel(value="Product Details", description="Contains all product details.")
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="PRODUCT_ID")
	private int PRODUCT_ID;
	
	@Column(name="PRODUCT_NAME")
	@Size(min=3, message="Name should have at least 3 characters")
	@ApiModelProperty(notes="Name should have at least 3 characters")
	private String PRODUCT_NAME;
	
	@Column(name="PRODUCT_DESCRIPTION")
	@Size(min=3, message="PRODUCT DESCRIPTION should have at least 3 characters")
	@ApiModelProperty(notes="PRODUCT DESCRIPTION should have at least 3 characters")
	private String PRODUCT_DESCRIPTION;
	
	@Column(name="PRICE")
	@DecimalMin("5.00")
	@ApiModelProperty(notes="Price has to be greater than 5.00.")
	private float PRICE;
	
	public Product() {
		
	}

	public Product(int pRODUCT_ID, String pRODUCT_NAME, String pRODUCT_DESCRIPTION, float pRICE) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
		PRICE = pRICE;
	}


	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getPRODUCT_DESCRIPTION() {
		return PRODUCT_DESCRIPTION;
	}

	public void setPRODUCT_DESCRIPTION(String pRODUCT_DESCRIPTION) {
		PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
	}

	public float getPRICE() {
		return PRICE;
	}

	public void setPRICE(float pRICE) {
		PRICE = pRICE;
	}

}
