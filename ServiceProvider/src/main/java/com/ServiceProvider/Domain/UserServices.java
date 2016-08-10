package com.ServiceProvider.Domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "user_services")
public class UserServices {
	@Id @Column(name="id")
	int id;
	@Column(name = "user_id")
	int user_id;
	@Column(name = "service_used")
	int service_id;
	@Column(name = "serviceprovider")
	int serviceProvider_id;
	@Transient
	String spEmail;
	@Transient
	String spName;
	@Transient
	float rating;
	@Transient
	String serviceName;
	@Column(name = "status")
	char status;
	
	
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public int getServiceProvider_id() {
		return serviceProvider_id;
	}
	public void setServiceProvider_id(int serviceProvider_id) {
		this.serviceProvider_id = serviceProvider_id;
	}
	public String getSpEmail() {
		return spEmail;
	}
	public void setSpEmail(String spEmail) {
		this.spEmail = spEmail;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserServices [user_id=" + user_id + ", service_id="
				+ service_id + ", serviceProvider_id=" + serviceProvider_id
				+ ", spEmail=" + spEmail + ", spName=" + spName
				+ ", serviceName=" + serviceName + ", status=" + status + "]";
	}
	
	
	
		
}
