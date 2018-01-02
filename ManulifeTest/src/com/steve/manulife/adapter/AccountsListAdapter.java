package com.steve.manulife.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.steve.manulife.data.Accounts;
import com.steve.manulifetest.ChequeAccHistory;
import com.steve.manulifetest.R;
import com.steve.manulifetest.SavingAccHistory;
import com.steve.manulifetest.TFSAAccHistory;

public class AccountsListAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private Context mContext;
	Accounts[] accounts;
	public AccountsListAdapter(Context mContext, Accounts[] accounts){
		this.mContext = mContext;
		this.mInflater = LayoutInflater.from(mContext);
		this.accounts = accounts;
	}

	public int getCount() {
		return accounts.length;
	}

	public Object getItem(int position) {
		return accounts[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();  
			convertView = mInflater.inflate(R.layout.orderlist, null);
			holder.accountName = (TextView) convertView.findViewById(R.id.account_name);
			holder.accountNum = (TextView) convertView.findViewById(R.id.account_num);
			holder.balance = (TextView) convertView.findViewById(R.id.balance);
//			holder.id = (TextView) convertView.findViewById(R.id.id);
			holder.accountName.setWidth(mContext.getResources().getDisplayMetrics().widthPixels*2/5);
			holder.accountNum.setWidth(mContext.getResources().getDisplayMetrics().widthPixels*2/5);
			holder.balance.setWidth(mContext.getResources().getDisplayMetrics().widthPixels/5);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.accountName.setText(accounts[position].getDisplayName());
		holder.accountNum.setText(accounts[position].getAccountNumber());
		holder.accountNum.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				switch(Integer.parseInt(accounts[position].getId())){
				case 10://go to cheque acc details page
					intent.setClass(mContext, ChequeAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				case 12://go to saving acc details page
					intent.setClass(mContext, SavingAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				case 19://go to TFSA acc details page
					intent.setClass(mContext, TFSAAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				default:
					break;
				}
			}
		});
		holder.balance.setText("$" + String.valueOf(accounts[position].getBalance()));
		holder.balance.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				switch(Integer.parseInt(accounts[position].getId())){
				case 10://go to cheque acc details page
					intent.setClass(mContext, ChequeAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				case 12://go to saving acc details page
					intent.setClass(mContext, SavingAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				case 19://go to TFSA acc details page
					intent.setClass(mContext, TFSAAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				default:
					break;
				}
			}
		});
//		holder.id.setText(String.valueOf(accounts[position].getId()));
		holder.accountName.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent();
				switch(Integer.parseInt(accounts[position].getId())){
				case 10://go to cheque acc details page
					intent.setClass(mContext, ChequeAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				case 12://go to saving acc details page
					intent.setClass(mContext, SavingAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				case 19://go to TFSA acc details page
					intent.setClass(mContext, TFSAAccHistory.class);
					AccountsListAdapter.this.mContext.startActivity(intent);
					((Activity) mContext).finish();
					break;
				default:
					break;
				}
			}
		});
		return convertView;
	}
	public final class ViewHolder {
		public TextView accountName;
		public TextView accountNum;
		public TextView balance;
//		public TextView id;
	}

}
