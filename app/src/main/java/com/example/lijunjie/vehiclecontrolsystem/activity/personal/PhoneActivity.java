package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 手机绑定
 */
public class PhoneActivity extends BaseRequestActivity {
    @BindView(R.id.phone_img_return)
    ImageView phoneImgReturn;
    @BindView(R.id.phone_et_phone)
    EditText phoneEtPhone;
    @BindView(R.id.phone_img_delete_phone)
    ImageView phoneImgDeletePhone;
    @BindView(R.id.phone_et_code)
    EditText phoneEtCode;
    @BindView(R.id.phone_tv_code)
    TextView phoneTvCode;
    @BindView(R.id.phone_preservation)
    Button phonePreservation;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_phone;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.phone_img_return, R.id.phone_img_delete_phone, R.id.phone_tv_code, R.id.phone_preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_img_return:
                finish();
                break;
            case R.id.phone_img_delete_phone:
                break;
            case R.id.phone_tv_code:
                break;
            case R.id.phone_preservation:
                break;
        }
    }
}
