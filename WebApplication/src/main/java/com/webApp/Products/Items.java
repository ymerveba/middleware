package com.webApp.Products;

import java.io.Serializable;


public class Items implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int price;
    
	private String productName;
	
	private int productID;


	public Items(int price, String productName, int productID) {
		super();
		this.price = price;
		this.productName = productName;
		this.productID = productID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Items [price=" + price + ", productName=" + productName
				+ ", productID=" + productID 
				+ "]";
	}

	

}
