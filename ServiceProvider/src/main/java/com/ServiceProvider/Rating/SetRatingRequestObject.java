package com.ServiceProvider.Rating;

public class SetRatingRequestObject {
private String serviceProvider;
private String password;
private String spEmail;
private float rated;
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
public float getRated() {
	return rated;
}
public void setRated(float rated) {
	this.rated = rated;
} 
}
