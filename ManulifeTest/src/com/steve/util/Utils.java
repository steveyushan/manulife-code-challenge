package com.steve.util;

import java.util.ArrayList;

import com.steve.manulife.data.AccTransactionHistory;

public class Utils {

	public static ArrayList<com.steve.manulife.data.Activity> addIntoArraylist(
			AccTransactionHistory[] result) {
		ArrayList<com.steve.manulife.data.Activity> activities= new ArrayList<com.steve.manulife.data.Activity>();
		for(int i = 0; i <= result.length-1; i++){
			for(int j = 0; j <= result[i].getActivity().length-1; j++){
				activities.add(result[i].getActivity()[j]);
			}
		}
		return activities;
	}
}
