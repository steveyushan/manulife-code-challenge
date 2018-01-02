package com.steve.manulifetest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.steve.manulife.adapter.ChequingHistoryAdapter;
import com.steve.manulife.data.AccTransactionHistory;
import com.steve.manulifetest.ui.widget.TitleBar;
import com.steve.util.Constants;
import com.steve.util.KvStorage;
import com.steve.util.Utils;

public class ChequeAccHistory extends Activity {
	TitleBar mTitleBar;
	ListView mListView;
	ListAdapter mListAdapter;
	TextView bannerDate;
	TextView bannerDespription;
	TextView bannerWithdrawal;
	TextView bannerDeposit;
	TextView bannerBalance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cheque_acc_history);
		mTitleBar = (TitleBar)findViewById(R.id.chequeacchistory_titlebar);
		mTitleBar.setOnClickListener(mTitleBarOnClickListener);
		mTitleBar.setVisibility(View.VISIBLE);
		bannerDate = (TextView)findViewById(R.id.banner_date);
		bannerDespription = (TextView)findViewById(R.id.banner_decription);
		bannerWithdrawal = (TextView)findViewById(R.id.banner_withdrawal);
		bannerDeposit = (TextView)findViewById(R.id.banner_deposit);
		bannerBalance = (TextView)findViewById(R.id.banner_balance);
		bannerDate.setWidth(getResources().getDisplayMetrics().widthPixels/6);
		bannerDespription.setWidth(getResources().getDisplayMetrics().widthPixels/3);
		bannerWithdrawal.setWidth(getResources().getDisplayMetrics().widthPixels/6);
		bannerDeposit.setWidth(getResources().getDisplayMetrics().widthPixels/6);
		bannerBalance.setWidth(getResources().getDisplayMetrics().widthPixels/6);
		
		ChequeAccHistoryTask task = new ChequeAccHistoryTask(this);
		task.execute(); 
	}
	class ChequeAccHistoryTask extends AsyncTask<String, String, AccTransactionHistory[]>{
		AccTransactionHistory[] accTransactionHistorys;
		Context context;
		public ChequeAccHistoryTask(Context context) {
			this.context = context;
		}
		@Override
		protected AccTransactionHistory[] doInBackground(String... params) {
			try{
				 InputStream stringData = getAssets().open("chequingAccount.json");
				 BufferedReader br=new BufferedReader(new InputStreamReader(stringData));
				 StringBuilder sb=new StringBuilder();
	             String line="";
	             while((line=br.readLine())!=null){
	                 sb.append(line);
	             }
	            Gson gson = new Gson();
	            accTransactionHistorys = gson.fromJson(sb.toString(), AccTransactionHistory[].class);
				}catch(Exception e) {
		            e.printStackTrace();
		        } 
				return accTransactionHistorys;
		}

		@Override
		protected void onPostExecute(AccTransactionHistory[] result) {
			//UI synchronize data 
			mListView = (ListView) findViewById(R.id.cheque_listview);
			//integrate into a list of activity
			mListAdapter = new ChequingHistoryAdapter(context, Utils.addIntoArraylist(result));
			mListView.setAdapter(mListAdapter);
		}
		
	}
	
    private View.OnClickListener mTitleBarOnClickListener = new View.OnClickListener()
    {
		public void onClick(View v) {
			switch (v.getId()){
			case R.id.titlebar_title_back:
				KvStorage mKvStorage = KvStorage.getInstance(getApplicationContext());
				mKvStorage.putBoolean(Constants.KEY_ACTIVE, true);
				mKvStorage.commit();
				android.os.Process.killProcess(android.os.Process.myPid());
	    		System.exit(0);
				break;
			default:
				break;
			}
		}
    };

	@Override
	public void onBackPressed() {
		Intent i = new Intent(this, ListOfAccounts.class);
		startActivity(i);
		this.finish();
	}

}
