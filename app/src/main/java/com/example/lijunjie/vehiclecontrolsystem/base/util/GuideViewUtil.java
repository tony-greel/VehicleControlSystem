package com.example.lijunjie.vehiclecontrolsystem.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.lijunjie.vehiclecontrolsystem.R;

/**
 * @author ghl
 * @category 设置浮层引导页工具类
 */
public class GuideViewUtil {
private SharedPreferences mGuideView_SP;
private Activity mActivity;
private int mimageViewId;
private  int count=0;
private ImageView mimageView;
public GuideViewUtil(Activity mActivity, int mimageViewId) {
	super();
	this.mActivity=mActivity;
	this.mimageViewId = mimageViewId;
	mGuideView_SP=mActivity.getSharedPreferences(mActivity.getClass().getName()+"GuideView", Context.MODE_PRIVATE);
	setGuideView();
}

	/**
	 * @return  返回内容区域根视图
	 */
	public View getRootView() {
	return (ViewGroup)mActivity.findViewById(android.R.id.content);
}

	/**
	 *  设置浮层引导页
	 */
	public void setGuideView() {
		View view=getRootView();
		if(view==null){
			return;
		}
		String guide_flag=mGuideView_SP.getString("Guide", null);
		if(guide_flag==mActivity.getClass().getName()){
			return;
		}
		final FrameLayout frameLayout=(FrameLayout)view;
		FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    	mimageView=new ImageView(mActivity);
		mimageView.setImageResource(mimageViewId);
		mimageView.setScaleType(ScaleType.FIT_XY);
		mimageView.setLayoutParams(layoutParams);
		mimageView.setOnClickListener(v -> {// TODO Auto-generated method stub
		  count++;

			switch (count){
				case 0:
					mimageView.setImageResource(R.drawable.xinshou1);
					break;
				case 1:
					mimageView.setImageResource(R.drawable.xinshou3);
					break;
				case 2:
					mimageView.setImageResource(R.drawable.xinshou5);
					mGuideView_SP.edit().putString("Guide", mActivity.getClass().getName()).commit();
					break;
				default:
					frameLayout.removeView(mimageView);
					return;
			}
		});
	frameLayout.addView(mimageView);
}
/**
 *  移除浮层引导页
 */
public void CancleGuideView(){
	String guide_flag=mGuideView_SP.getString("Guide", null);
	if(guide_flag!=mActivity.getClass().getName()){
		return;
	}
	FrameLayout view=(FrameLayout)getRootView();
	if(view==null){
		return;
	}
	view.removeView(mimageView);
	
}
}
