package com.webApp.Products;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product_info")
public class Product_Info {
  
	@Column(name="price")
	private int price;
    @Column(name="productName")
	private String productName;
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)*/
    @Id @GeneratedValue
    @Column(name="productID")
	private int productID;
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
 
	
}
