package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 关于
 */
public class AboutActivity extends BaseRequestActivity {
    @BindView(R.id.about_img_return)
    ImageView aboutImgReturn;
    @BindView(R.id.about_fl_to_update)
    FrameLayout aboutFlToUpdate;
    @BindView(R.id.about_fl_official_network)
    FrameLayout aboutFlOfficialNetwork;
    @BindView(R.id.about_fl_help)
    FrameLayout aboutFlHelp;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_about;
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

    @OnClick({R.id.about_img_return, R.id.about_fl_to_update, R.id.about_fl_official_network, R.id.about_fl_help})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.about_img_return:
                finish();
                break;
            case R.id.about_fl_to_update:
                break;
            case R.id.about_fl_official_network:
                break;
            case R.id.about_fl_help:
                break;
        }
    }
}
