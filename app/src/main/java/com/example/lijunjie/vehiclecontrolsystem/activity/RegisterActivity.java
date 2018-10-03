package com.example.lijunjie.vehiclecontrolsystem.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.util.CountDownTimerUtils;
import com.example.lijunjie.vehiclecontrolsystem.base.util.InputBoxUtil;
import com.example.lijunjie.vehiclecontrolsystem.base.util.ToastHelper;
import com.example.lijunjie.vehiclecontrolsystem.bean.UserBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseRequestActivity<UserBean> {


    @BindView(R.id.register_img_return)
    ImageView registerImgReturn;
    @BindView(R.id.register_et_phone)
    EditText registerEtPhone;
    @BindView(R.id.register_img_delete_phone)
    ImageView registerImgDeletePhone;
    @BindView(R.id.register_et_password)
    EditText registerEtPassword;
    @BindView(R.id.register_img_delete_password)
    ImageView registerImgDeletePassword;
    @BindView(R.id.register_img_close_password)
    ImageView registerImgClosePassword;
    @BindView(R.id.register_et_verification_code)
    EditText registerEtVerificationCode;
    @BindView(R.id.register_tv_verification_code)
    TextView registerTvVerificationCode;
    @BindView(R.id.register_bt)
    Button registerBt;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(registerEtPhone,registerImgDeletePhone);
        InputBoxUtil.initView(registerEtPassword,registerImgDeletePassword);
    }

    @OnClick({R.id.register_img_return, R.id.register_img_delete_phone,
            R.id.register_img_delete_password, R.id.register_img_close_password,
            R.id.register_tv_verification_code, R.id.register_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_img_return:
                goToOtherActivity(LoginActivity.class, true);
                finish();
                break;
            case R.id.register_img_delete_phone:
                registerEtPhone.setText("");
                break;
            case R.id.register_img_delete_password:
                registerEtPassword.setText("");
                break;
            case R.id.register_img_close_password:
                InputBoxUtil.imgPasswordDisappearMonitor(registerEtPassword,registerImgClosePassword);
                break;
            case R.id.register_tv_verification_code:
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(registerTvVerificationCode, 60000, 1000);
                mCountDownTimerUtils.start();
                break;
            case R.id.register_bt:
                startRequest();
                break;
        }
    }

    @Override
    protected boolean validationInput() {
        if (TextUtils.isEmpty(registerEtPhone.getText().toString())) {
            ToastHelper.toast(R.string.number_not_empty);
            return false;
        } else if (TextUtils.isEmpty(registerEtPassword.getText().toString())) {
            ToastHelper.toast(R.string.password_not_empty);
            return false;
        } else if (TextUtils.isEmpty(registerEtVerificationCode.getText().toString())) {
            ToastHelper.toast(R.string.verification_code);
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
