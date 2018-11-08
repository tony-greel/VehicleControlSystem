package com.example.lijunjie.vehiclecontrolsystem.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.util.InputBoxUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPasswordActivity extends BaseRequestActivity {

    @BindView(R.id.reset_password_img_return)
    ImageView resetPasswordImgReturn;
    @BindView(R.id.reset_password_et_phone)
    EditText resetPasswordEtPhone;
    @BindView(R.id.reset_password_img_delete_phone)
    ImageView resetPasswordImgDeletePhone;
    @BindView(R.id.reset_password_et)
    EditText resetPasswordEt;
    @BindView(R.id.reset_password_img)
    ImageView resetPasswordImg;
    @BindView(R.id.reset_password_bt)
    Button resetPasswordBt;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_reset_password;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(resetPasswordEtPhone,resetPasswordImgDeletePhone);
        InputBoxUtil.initView(resetPasswordEt,resetPasswordImg);
    }

    @OnClick({R.id.reset_password_img_return, R.id.reset_password_img_delete_phone, R.id.reset_password_img, R.id.reset_password_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reset_password_img_return:
                finish();
                break;
            case R.id.reset_password_img_delete_phone:
                resetPasswordEtPhone.setText("");
                break;
            case R.id.reset_password_img:
                resetPasswordEt.setText("");
                break;
            case R.id.reset_password_bt:
                break;
        }
    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {
    }

    @Override
    public boolean isOnCreateRequest() {
        return false;
    }
}
