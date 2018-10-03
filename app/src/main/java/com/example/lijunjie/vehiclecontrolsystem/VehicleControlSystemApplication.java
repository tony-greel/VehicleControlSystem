package com.example.lijunjie.vehiclecontrolsystem;

import android.app.Application;
import android.content.Context;


public class VehicleControlSystemApplication extends Application {

    public static Context mcontext;

    public static Context getContext() {
        return mcontext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
    }
}
