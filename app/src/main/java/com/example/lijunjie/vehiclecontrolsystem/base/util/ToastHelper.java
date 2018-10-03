package com.example.lijunjie.vehiclecontrolsystem.base.util;

import android.widget.Toast;

import com.example.lijunjie.vehiclecontrolsystem.VehicleControlSystemApplication;

public class ToastHelper {

  public static void toast(String msg){
    Toast.makeText(VehicleControlSystemApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
  }

  public static void toast(int resId){
    toast(UiHelper.getString(resId));
  }

}
