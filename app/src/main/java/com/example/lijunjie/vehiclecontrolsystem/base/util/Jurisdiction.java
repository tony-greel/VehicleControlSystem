package com.example.lijunjie.vehiclecontrolsystem.base.util;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.lijunjie.vehiclecontrolsystem.R;

/**
 * Created by lijunjie on 2018/5/4.
 */

public class Jurisdiction {

    public static final int PERMISSION_DENIEG = 1;//权限不足，权限被拒绝的时候
    private static final String PACKAGE_URL_SCHEME = "package:";//权限方案

    /**
     * 定位权限的判断与申请
     * @param activity
     */
    public static void getLocationPre(Activity activity) {
        //首先进行判断有无定位权限
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
    }


    public static void showMissingPermissionDialog(int requestCode, int[] grantResults, final Activity activity) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("帮助");//提示帮助
                builder.setMessage(R.string.string_help_text);

                //如果是拒绝授权，返回
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.setResult(PERMISSION_DENIEG);//权限不足
                        Toast.makeText(activity, "取消", Toast.LENGTH_SHORT).show();
                        return;
                    }
                });
                builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //跳转系统应用权限
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + activity.getPackageName()));
                        activity.startActivity(intent);
                        return;
                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        }
    }
}
