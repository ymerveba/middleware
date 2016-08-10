package com.middleware.spring.WebApp;

import java.io.Serializable;

public class WebAppDiscountResponseObject implements Serializable{
	 
    private static final long serialVersionUID = -7788619177798333712L;
     
	
  private String WebAppId;
  private String userID;
  private double discount;
  private String message;
  
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

public String getWebAppId() {
	return WebAppId;
}
public void setWebAppId(String webAppId) {
	WebAppId = webAppId;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}

}
