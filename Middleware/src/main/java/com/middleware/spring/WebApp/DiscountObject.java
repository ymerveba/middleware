package com.middleware.spring.WebApp;

public class DiscountObject {
	double Avg_rating;
	int num_of_people;
	double spTotalTransactionAMount;
	int spNumberOfTransaction;
	int WebAppNumberOfTransactions;
	double WebAppTotalTransactions;
	double Discount;
	
	
	public String getString() {
		return "DiscountObject [Avg_rating=" + Avg_rating + ", num_of_people="
				+ num_of_people + ", spTotalTransactionAMount="
				+ spTotalTransactionAMount + ", spNumberOfTransaction="
				+ spNumberOfTransaction + ", WebAppNumberOfTransactions="
				+ WebAppNumberOfTransactions + ", WebAppTotalTransactions="
				+ WebAppTotalTransactions + ", Discount=" + Discount + "]";
	}
	public double getDiscount() {
		return Discount;
	}
	public void setDiscount(double discount) {
		Discount = discount;
	}
	public double getAvg_rating() {
		return Avg_rating;
	}
	public void setAvg_rating(float avg_rating) {
		Avg_rating = avg_rating;
	}
	public int getNum_of_people() {
		return num_of_people;
	}
	public void setNum_of_people(int num_of_people) {
		this.num_of_people = num_of_people;
	}
	public double getSpTotalTransactionAMount() {
		return spTotalTransactionAMount;
	}
	public void setSpTotalTransactionAMount(double spTotalTransactionAMount) {
		this.spTotalTransactionAMount = spTotalTransactionAMount;
	}
	public int getSpNumberOfTransaction() {
		return spNumberOfTransaction;
	}
	public void setSpNumberOfTransaction(int spNumberOfTransaction) {
		this.spNumberOfTransaction = spNumberOfTransaction;
	}
	public int getWebAppNumberOfTransactions() {
		return WebAppNumberOfTransactions;
	}
	public void setWebAppNumberOfTransactions(int webAppNumberOfTransactions) {
		WebAppNumberOfTransactions = webAppNumberOfTransactions;
	}
	public double getWebAppTotalTransactions() {
		return WebAppTotalTransactions;
	}
	public void setWebAppTotalTransactions(double webAppTotalTransactions) {
		WebAppTotalTransactions = webAppTotalTransactions;
	}
	
}
