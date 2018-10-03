package com.example.lijunjie.vehiclecontrolsystem.activity;

import android.os.Bundle;
import android.widget.Button;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartUpActivity extends BaseRequestActivity {

    @BindView(R.id.start_up_skip_bt)
    Button startUpSkipBt;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_start_up;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_up_skip_bt)
    public void onViewClicked() {
        goToOtherActivity(LoginActivity.class, true);
        finish();
    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object o) {

    }

    public boolean isOnCreateRequest() {
        return false;
    }

}
