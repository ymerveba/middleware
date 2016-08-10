package com.webApp.Check_Out;

import java.util.ArrayList;
import java.util.List;



public class Cart {
	
	
	List<String> cartlist = new ArrayList<String>();

	
	public List<String> getCartlist() {
		return cartlist;
	}


	@SuppressWarnings("unchecked")
	public void setCartlist(@SuppressWarnings("rawtypes") List cartlist) {
		this.cartlist.addAll(cartlist);
	}
	
}
