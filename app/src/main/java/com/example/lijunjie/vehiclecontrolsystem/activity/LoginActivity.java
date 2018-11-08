package com.example.lijunjie.vehiclecontrolsystem.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.MainActivity;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.util.InputBoxUtil;
import com.example.lijunjie.vehiclecontrolsystem.base.util.ToastHelper;
import com.example.lijunjie.vehiclecontrolsystem.bean.UserBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseRequestActivity<UserBean>{


    @BindView(R.id.log_img_delete_phone)
    ImageView logImgDeletePhone;
    @BindView(R.id.log_et_phone)
    EditText logEtPhone;
    @BindView(R.id.log_img_delete_password)
    ImageView logImgDeletePassword;
    @BindView(R.id.log_img_close_password)
    ImageView logImgClosePassword;
    @BindView(R.id.log_et_password)
    EditText logEtPassword;
    @BindView(R.id.log_bt_login)
    Button logBtLogin;
    @BindView(R.id.log_tv_forget_password)
    TextView logTvForgetThePassword;
    @BindView(R.id.log_tv_register)
    TextView logTvRegister;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(logEtPhone,logImgDeletePhone);
        InputBoxUtil.initView(logEtPassword,logImgDeletePassword);
    }

    @OnClick({R.id.log_img_delete_password, R.id.log_img_close_password, R.id.log_bt_login,
            R.id.log_tv_forget_password, R.id.log_tv_register, R.id.log_img_delete_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.log_img_delete_password:
                logEtPassword.setText("");
                break;
            case R.id.log_img_close_password:
                InputBoxUtil.imgPasswordDisappearMonitor(logEtPassword,logImgClosePassword);
                break;
            case R.id.log_bt_login:
//                startRequest();
                goToOtherActivity(MainActivity.class, true);
                break;
            case R.id.log_tv_forget_password:
                goToOtherActivity(ForgetPasswordActivity.class, false);
                break;
            case R.id.log_tv_register:
                 goToOtherActivity(RegisterActivity.class, false);
                break;
            case R.id.log_img_delete_phone:
                logEtPhone.setText("");
                break;
        }
   }

    @Override
    protected boolean validationInput() {
        if (TextUtils.isEmpty(logEtPhone.getText().toString())) {
            ToastHelper.toast(R.string.number_not_empty);
            return false;
        } else if (TextUtils.isEmpty(logEtPassword.getText().toString())) {
            ToastHelper.toast(R.string.password_not_empty);
            return false;
        }
        return true;
    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(UserBean userBean) {

    }

    @Override
    public boolean isOnCreateRequest() {
        return false;
    }
}
