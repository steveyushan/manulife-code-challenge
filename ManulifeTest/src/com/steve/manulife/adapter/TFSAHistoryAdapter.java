package com.steve.manulife.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.steve.manulifetest.R;

public class TFSAHistoryAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private Context mContext;
	private ArrayList<com.steve.manulife.data.Activity> activities;
	public TFSAHistoryAdapter(Context mContext, ArrayList<com.steve.manulife.data.Activity> activities) {
		this.mInflater = LayoutInflater.from(mContext);
		this.mContext = mContext;
		this.activities = activities;
	}
	public int getCount() {
		return activities.size();
	}
	public Object getItem(int position) {
		return activities.get(position);
	}
	public long getItemId(int position) {
		return position;
	}
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();  
			convertView = mInflater.inflate(R.layout.historylist, null);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.description = (TextView) convertView.findViewById(R.id.desciption);
			holder.withdrawal_mount = (TextView) convertView.findViewById(R.id.withdrawal_amount);
			holder.deposit_mount = (TextView) convertView.findViewById(R.id.deposit_amount);
			holder.balance = (TextView) convertView.findViewById(R.id.balance);
			holder.date.setWidth(mContext.getResources().getDisplayMetrics().widthPixels/6);
			holder.description.setWidth(mContext.getResources().getDisplayMetrics().widthPixels/3);
			holder.withdrawal_mount.setWidth(mContext.getResources().getDisplayMetrics().widthPixels/6);
			holder.deposit_mount.setWidth(mContext.getResources().getDisplayMetrics().widthPixels/6);
			holder.balance.setWidth(mContext.getResources().getDisplayMetrics().widthPixels/6);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.date.setText(activities.get(position).getDate());
		holder.description.setText(activities.get(position).getDescription());
		holder.withdrawal_mount.setText(activities.get(position).getWithdrawal_amount() == null ? "" : 
			"$" + activities.get(position).getWithdrawal_amount());
		holder.deposit_mount.setText(activities.get(position).getDeposit_amount() == null ? "" : 
			"$" + activities.get(position).getDeposit_amount());
		holder.balance.setText(activities.get(position).getBalance() == null ? "" : 
			"$" + activities.get(position).getBalance());
		return convertView;
	}
	public final class ViewHolder {
		public TextView date;
		public TextView description;
		public TextView withdrawal_mount;
		public TextView deposit_mount;
		public TextView balance;
	}
}
