package com.example.lijunjie.vehiclecontrolsystem.base.interfaces;

import android.os.Bundle;
import android.widget.EditText;

public interface IBaseActivity {

  void goToOtherActivity(Class<?> cls,boolean isFinish);

  void goToOtherActivity(Class<?> cls, Bundle bundle, boolean isFinish);

  void goToOtherActivityForResult(Class<?> cls, Bundle bundle, int requestCode);

  void backForResult(Class<?> cls, Bundle bundle, int resultCode);

  void initViewWithIntentData(Bundle bundle);

  void showLoadingView();

  void closeLoadingView();

  void hideInputWindow();

  void showInputWindow(EditText mEditText);



}
