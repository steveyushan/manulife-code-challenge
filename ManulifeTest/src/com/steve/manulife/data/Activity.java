package com.steve.manulife.data;

public class Activity {
	String id;
	String date;
	String description;
	String withdrawal_amount;
	String deposit_amount;
	String balance;
	String transaction_uid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWithdrawal_amount() {
		return withdrawal_amount;
	}
	public void setWithdrawal_amount(String withdrawal_amount) {
		this.withdrawal_amount = withdrawal_amount;
	}
	public String getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(String deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getTransaction_uid() {
		return transaction_uid;
	}
	public void setTransaction_uid(String transaction_uid) {
		this.transaction_uid = transaction_uid;
	}
}
