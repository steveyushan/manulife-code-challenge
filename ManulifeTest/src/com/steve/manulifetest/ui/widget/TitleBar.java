package com.steve.manulifetest.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.steve.manulifetest.R;

public class TitleBar extends RelativeLayout{
	
	// view tag, according tag to know which view is clicked
	public final static int TITLEBARBACK_VIEWTAG = R.id.titlebar_title_back;
	public final static int TITLEBARTITLE_VIEWTAG = R.id.titlebar_title;
	
	private TextView mTitleBarBack;
	private TextView mTitleBarTitle;
	
	public TitleBar(Context context) {
		super(context);
		setupView();
	}

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		setupView();
	}

	public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setupView();
	}
	
	public void setOnClickListener(OnClickListener l){
		mTitleBarBack.setOnClickListener(l);
	}

	private void setupView() {
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.titlebar, this, true);
	    mTitleBarBack = (TextView) viewGroup.findViewById(R.id.titlebar_title_back);
		mTitleBarTitle = (TextView) viewGroup.findViewById(R.id.titlebar_title);
		
	    String tag = (String)getTag();
	    mTitleBarTitle.setText(tag);
	    mTitleBarBack.setTag(TITLEBARBACK_VIEWTAG);
	    
	    new Rect(0, 0, getContext().getResources().getDisplayMetrics().widthPixels,
	            (int)getContext().getResources().getDimension(R.dimen.titlebar_height));
	}
	
	public void setTitleBarBackVisibility(int visibility){
		mTitleBarBack.setVisibility(visibility);
	}
	
	public void setTitleBarHomeVisibility(int visibility){
//		mTitleBarHome.setVisibility(visibility);
	}

	@Override
	public void setTag(Object tag) {
		super.setTag(tag);
	    if (mTitleBarTitle != null){
	    	mTitleBarTitle.setText((String)tag);
	    }
	}
	public TextView getTitleBarTitle(){
		return mTitleBarTitle;
	}
	
}
