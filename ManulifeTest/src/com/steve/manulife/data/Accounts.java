package com.steve.manulife.data;

public class Accounts {
	String id;
	String display_name;
	String account_number;
	String balance;
	
	public Accounts() {
		super();
	}

	public Accounts(String id, String display_name, String account_number,
			String balance) {
		super();
		this.id = id;
		this.display_name = display_name;
		this.account_number = account_number;
		this.balance = balance;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public void setDisplayName(String display_name){
		this.display_name = display_name;
	}
	public void setAccountNumber(String account_number){
		this.account_number = account_number;
	}
	public void setBalance(String balance){
		this.balance = balance;
	}
	
	public String getId(){
		return id;
	}
	public String getDisplayName(){
		return display_name;
	}
	
	public String getAccountNumber(){
		return account_number;
	}
	public String getBalance(){
		return balance;
	}
}
