package com.webApp.Domain;

import java.io.Serializable;



public class DiscountRequestObject implements Serializable{
	 
    private static final long serialVersionUID = -7788619177798333712L;
     
	
  private String WebAppId;

  private String Password;
	
  private String userID;
	
  private int numberOfTransactions;
  private double TotalValue;
  
public int getNumberOfTransactions() {
	return numberOfTransactions;
}

public void setNumberOfTransactions(int numberOfTransactions) {
	this.numberOfTransactions = numberOfTransactions;
}

public double getTotalValue() {
	return TotalValue;
}

public void setTotalValue(double totalValue) {
	TotalValue = totalValue;
}

public String getWebAppId() {
	return WebAppId;
}
  
public void setWebAppId(String webAppId) {
	WebAppId = webAppId;
}

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}




  



   
}
