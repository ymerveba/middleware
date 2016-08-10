package com.webApp.Login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class LoginForm {
	@Id
	
	@Column(name="email_id")
	String userID;
	@Column(name="password")
	String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String UserID) {
		this.userID = UserID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [UserID=" + userID + ", password=" + password + "]";
	}

	
}
