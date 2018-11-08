package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.account.ModifyActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.account.VerificationActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 车控安全
 */
public class CarControlActivity extends BaseRequestActivity {
    @BindView(R.id.car_control_img_return)
    ImageView carControlImgReturn;
    @BindView(R.id.car_control_tv_set_up)
    TextView carControlTvSetUp;
    @BindView(R.id.car_control_tv)
    TextView carControlTv;
    @BindView(R.id.car_control_fl_control)
    FrameLayout carControlFlControl;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_car_control;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);

    }

    @OnClick({R.id.car_control_img_return, R.id.car_control_fl_control})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.car_control_img_return:
                finish();
                break;
            case R.id.car_control_fl_control:
                goToOtherActivity(VerificationActivity.class, false);
                break;
        }
    }
}
