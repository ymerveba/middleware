package com.ServiceProvider.Rating;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "rating")
public class Rating implements Serializable{
	 private static final long serialVersionUID = -7788619177798333712L;
	@Id@Column(name="id")
	int id;
	@Column(name="email_id")
	String SP_email;
	@Column(name="totalrating")
	float rating;
	@Column(name="NumberOfRating")
	int numberOfRatings;
	int s_id;
	int sp_id;
	char status;
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getSp_id() {
		return sp_id;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getSP_email() {
		return SP_email;
	}
	public void setSP_email(String sP_email) {
		SP_email = sP_email;
	}
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
	public int getNumberOfRatings() {
		return numberOfRatings;
	}
	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	}
