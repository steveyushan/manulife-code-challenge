package com.steve.manulife.data;

public class AccTransactionHistory {

	String date;
	Activity[] activity;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Activity[] getActivity() {
		return activity;
	}
	public void setActivity(Activity[] activity) {
		this.activity = activity;
	}

}
