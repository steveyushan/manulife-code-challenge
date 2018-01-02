package com.steve.manulifetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.steve.util.Constants;
import com.steve.util.KvStorage;

public class MainActivity extends Activity implements OnClickListener{
	
	Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Handler h = new Handler();
        h.post(new Runnable() {
			
			public void run() {
		         if (!isFirstLaunch()) {
	                    Intent i = new Intent();
	                    i.setClass(MainActivity.this, ListOfAccounts.class);
	                    startActivity(i);
	                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	                    finish();
	                } else{
	              
	                }
			}
		});	   
		mButton = (Button)findViewById(R.id.open);
		mButton.setOnClickListener(this);
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
	}



	public void onClick(View v) {
		switch (v.getId()){
		case R.id.open:
			setFirstLaunch(this, false);
			Intent intent = new Intent(this, ListOfAccounts.class);
			startActivity(intent);
			this.finish();
			break;
		default:
			break;
		}
	}
	private void setFirstLaunch(Context mcontext, boolean isFirstLaunch){
		KvStorage mKvStorage = KvStorage.getInstance(mcontext);
		mKvStorage.putBoolean(Constants.KEY_ACTIVE, false);
		mKvStorage.commit();
	}

	private boolean isFirstLaunch(){
		KvStorage mKvStorage = KvStorage.getInstance(this);
		Boolean isFirstLaunch = mKvStorage.getBoolean(Constants.KEY_ACTIVE, true);
		return isFirstLaunch;
	}

}
