package com.middleware.spring.ServiceProvider;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;





@Entity

@Table(name = "rating")
public class Rating implements Serializable{
	 private static final long serialVersionUID = -7788619177798333712L;
	@Id@Column(name="id")
	@GeneratedValue
	int id;
	@Column(name="email_id")
	String SP_email;
	@Column(name="totalrating")
	float rating;
	@Column(name="NumberOfRating")
	int numberOfRatings;
	public String getSP_email() {
		return SP_email;
	}
	public void setSP_email(String sP_email) {
		SP_email = sP_email;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float f) {
		this.rating = f;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumberOfRatings() {
		return numberOfRatings;
	}
	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	}
