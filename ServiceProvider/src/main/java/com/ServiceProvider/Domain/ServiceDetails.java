package com.ServiceProvider.Domain;


public class ServiceDetails {

	String SP_name;
	String SP_email;
	int service_id;
	int rating;
	
	public String getSp_name() {
		return SP_name;
	}
	public void setSp_name(String sp_name) {
		this.SP_name = sp_name;
	}
	
	public String getSP_name() {
		return SP_name;
	}
	public void setSP_name(String sP_name) {
		SP_name = sP_name;
	}
	public String getSP_email() {
		return SP_email;
	}
	public void setSP_email(String sP_email) {
		SP_email = sP_email;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	

}
