package com.middleware.spring.ServiceProvider;

public class SetRatingRequestObject {
private String serviceProvider;
private String password;
private String spEmail;
private int rated;
public String getServiceProvider() {
	return serviceProvider;
}
public void setServiceProvider(String serviceProvider) {
	this.serviceProvider = serviceProvider;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSpEmail() {
	return spEmail;
}
public void setSpEmail(String spEmail) {
	this.spEmail = spEmail;
}
public int getRated() {
	return rated;
}
public void setRated(int rated) {
	this.rated = rated;
} 
}
