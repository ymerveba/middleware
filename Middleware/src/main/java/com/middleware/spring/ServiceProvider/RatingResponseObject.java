package com.middleware.spring.ServiceProvider;

import java.io.Serializable;
import java.util.List;

public class RatingResponseObject implements Serializable{
	 private static final long serialVersionUID = -7788619177798333712L;
private List<Rating> rating;
private String serviceProvider;
public List<Rating> getRating() {
	return rating;
}
public void setRating(List<Rating> rating) {
	this.rating = rating;
}
public String getServiceProvider() {
	return serviceProvider;
}
public void setServiceProvider(String serviceProvider) {
	this.serviceProvider = serviceProvider;
}



}
