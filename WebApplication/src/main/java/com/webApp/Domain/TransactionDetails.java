package com.webApp.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionDetails {

	@Column(name = "transaction_id")
	int transaction_id;
	
	@Column(name = "item_id")
	int item_id;

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	
	
	
}
