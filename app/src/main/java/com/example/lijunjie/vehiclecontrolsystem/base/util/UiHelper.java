package com.example.lijunjie.vehiclecontrolsystem.base.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lijunjie.vehiclecontrolsystem.VehicleControlSystemApplication;

public class UiHelper {

  public static View inflater(int resId,ViewGroup parent){
    return LayoutInflater.from(parent.getContext()).inflate(resId,parent);
  }

  public static View inflater(Context context,int resId,ViewGroup parent){
    return LayoutInflater.from(context).inflate(resId,parent);
  }

  public static String getString(int resId){
    return VehicleControlSystemApplication.getContext().getResources().getString(resId);
  }

  public static int getColor(int resId){
    return VehicleControlSystemApplication.getContext().getResources().getColor(resId);
  }

  public static LinearLayout getLinearLayout(Context context){
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(LinearLayout.VERTICAL);
    return linearLayout;
  }

  public static DisplayMetrics getDisplayMetrics() {
    return VehicleControlSystemApplication.getContext().getResources().getDisplayMetrics();
  }

  //public static void setViewSize(View view,ImageSizeBean viewSize) {
  //  ViewGroup.LayoutParams params = view.getLayoutParams();
  //  if (params == null){
  //    params = new ViewGroup.LayoutParams(viewSize.getWidth(),viewSize.getHeight());
  //  }
  //  params.width = viewSize.getWidth();
  //  params.height = viewSize.getHeight();
  //  view.setLayoutParams(params);
  //  view.requestLayout();
  //}
  //
  //public static boolean isLongImage(ImageSizeBean bean){
  //  float screenScale = DensityUtil.getScreenHeight()*1.0f/DensityUtil.getScreenWidth();
  //  float imageScale = bean.getHeight()*1.0f/bean.getWidth();
  //  return imageScale > screenScale;
  //}

}
