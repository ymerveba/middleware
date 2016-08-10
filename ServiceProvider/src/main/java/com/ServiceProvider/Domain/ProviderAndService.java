package com.ServiceProvider.Domain;


public class ProviderAndService  {
	
	private int id;
	private String serviceProviderEmail;
	private int sp_id;
	private String serviceProvider;
	private int service_id;
	private float rating;
	private int numberOfRating;
	
	public int getNumberOfRating() {
		return numberOfRating;
	}
	public void setNumberOfRating(int numberOfRating) {
		this.numberOfRating = numberOfRating;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getServiceProviderEmail() {
		return serviceProviderEmail;
	}
	public void setServiceProviderEmail(String serviceProviderEmail) {
		this.serviceProviderEmail = serviceProviderEmail;
	}
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSp_id() {
		return sp_id;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	@Override
	public String toString() {
		return "ProviderAndService [id=" + id + ", serviceProviderEmail="
				+ serviceProviderEmail + ", sp_id=" + sp_id
				+ ", serviceProvider=" + serviceProvider + ", service_id="
				+ service_id + ", rating=" + rating + ", numberOfRating="
				+ numberOfRating + "]";
	}

	
	
	
	

}
