package com.middleware.spring.ServiceProvider;

import java.util.List;

public class RatingRequestObject {
private List<String> emails;
private String ServiceProviderID;
private String password;
public List<String> getEmails() {
	return emails;
}
public void setEmails(List<String> emails) {
	this.emails = emails;
}
public String getServiceProviderID() {
	return ServiceProviderID;
}
public void setServiceProviderID(String serviceProviderID) {
	ServiceProviderID = serviceProviderID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
