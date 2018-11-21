package com.example.lijunjie.vehiclecontrolsystem.base.util;

import android.content.Context;
import android.widget.Toast;

import com.example.lijunjie.vehiclecontrolsystem.VehicleControlSystemApplication;

public class ToastHelper {

  private static Toast mShortToast;

  public static void toast(String msg){
    Toast.makeText(VehicleControlSystemApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
  }

  public static void toast(int resId){
    toast(UiHelper.getString(resId));
  }

  public static void showToast(Context context, String message) {
    if (mShortToast == null) {
      mShortToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
    }
    mShortToast.setText(message);
    mShortToast.show();

  }
}
