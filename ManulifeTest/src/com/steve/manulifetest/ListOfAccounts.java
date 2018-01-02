package com.steve.manulifetest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.steve.manulife.adapter.AccountsListAdapter;
import com.steve.manulife.data.Accounts;
import com.steve.manulifetest.ui.widget.TitleBar;
import com.steve.util.Constants;
import com.steve.util.KvStorage;

public class ListOfAccounts extends Activity{
	
	TitleBar mTitleBar;
	ListView mListView;
	ListAdapter mListAdapter;
	TextView bannerAccount;
	TextView bannerAccNum;
	TextView bannerBalance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listofaccounts);
		mTitleBar = (TitleBar)findViewById(R.id.listofaccounts_titlebar);
		mTitleBar.setOnClickListener(mTitleBarOnClickListener);
		mTitleBar.setVisibility(View.VISIBLE);
		bannerAccount = (TextView)findViewById(R.id.banner_account);
		bannerAccNum = (TextView)findViewById(R.id.banner_accnum);
		bannerBalance = (TextView)findViewById(R.id.banner_balance);
		bannerAccount.setWidth(getResources().getDisplayMetrics().widthPixels*2/5);
		bannerAccNum.setWidth(getResources().getDisplayMetrics().widthPixels*2/5);
		bannerBalance.setWidth(getResources().getDisplayMetrics().widthPixels/5);
		ListOfAccountsTask task = new ListOfAccountsTask(this);
		task.execute(); 
	}
	
	class ListOfAccountsTask extends AsyncTask<String, String, Accounts[]>{
		Accounts[] accounts;
		Context context;
		public ListOfAccountsTask(Context context) {
			this.context = context;
		}


		@Override
		protected Accounts[] doInBackground(String... params) {
			try{
			 InputStream stringData = getAssets().open("listOfAccounts.json");
			 BufferedReader br=new BufferedReader(new InputStreamReader(stringData));
			 StringBuilder sb=new StringBuilder();
             String line="";
             while((line=br.readLine())!=null){
                 sb.append(line);
             }
            Gson gson = new Gson();
            accounts = gson.fromJson(sb.toString(), Accounts[].class);
			}catch(Exception e) {
	            e.printStackTrace();
	        } 
			return accounts;
		}


		@Override
		protected void onPostExecute(Accounts[] accounts) {
			//UI synchronize data 
			mListView = (ListView) findViewById(R.id.listview);
			mListAdapter = new AccountsListAdapter(context, accounts);
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
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}
}
