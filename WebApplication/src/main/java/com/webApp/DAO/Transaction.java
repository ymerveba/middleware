package com.webApp.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transactions")
public class Transaction {
@Id
	 @Column(name="user_id")
private String user_id;
	 @Column(name="total_amt")
private double total_amt;
	 @Column(name="numberOfTransactions")
private int numberOfTransactions;

public int getNumberOfTransactions() {
		return numberOfTransactions;
	}
	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public double getTotal_amt() {
	return total_amt;
}
public void setTotal_amt(double total_amt) {
	this.total_amt = total_amt;
}

}
