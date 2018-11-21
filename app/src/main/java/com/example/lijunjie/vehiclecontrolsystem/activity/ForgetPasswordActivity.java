package com.example.lijunjie.vehiclecontrolsystem.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.util.CountDownTimerUtils;
import com.example.lijunjie.vehiclecontrolsystem.base.util.InputBoxUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class ForgetPasswordActivity extends BaseRequestActivity {


    @BindView(R.id.forget_password_img_return)
    ImageView forgetPasswordImgReturn;
    @BindView(R.id.forget_password_et_phone)
    EditText forgetPasswordEtPhone;
    @BindView(R.id.forget_password_img_delete_phone)
    ImageView forgetPasswordImgDeletePhone;
    @BindView(R.id.forget_password_et_verification_code)
    EditText forgetPasswordEtVerificationCode;
    @BindView(R.id.forget_password_tv_verification_code)
    TextView forgetPasswordTvVerificationCode;
    @BindView(R.id.forget_password_bt)
    Button forgetPasswordBt;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(forgetPasswordEtPhone,forgetPasswordImgDeletePhone);
    }

    @OnClick({R.id.forget_password_img_return, R.id.forget_password_img_delete_phone, R.id.forget_password_tv_verification_code, R.id.forget_password_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_password_img_return:
                finish();
                break;
            case R.id.forget_password_img_delete_phone:
                break;
            case R.id.forget_password_tv_verification_code:
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(forgetPasswordTvVerificationCode, 60000, 1000);
                mCountDownTimerUtils.start();
                break;
            case R.id.forget_password_bt:
                goToOtherActivity(ResetPasswordActivity.class, false);
                break;
        }
    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object o) {

    }

    @Override
    public boolean isOnCreateRequest() {
        return false;
    }
}
