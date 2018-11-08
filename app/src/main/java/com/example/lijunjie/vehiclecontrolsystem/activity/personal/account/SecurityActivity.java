package com.example.lijunjie.vehiclecontrolsystem.activity.personal.account;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 账号安全
 */
public class SecurityActivity extends BaseRequestActivity {

    @BindView(R.id.security_img_return)
    ImageView securityImgReturn;
    @BindView(R.id.security_fl_control)
    FrameLayout securityFlControl;
    @BindView(R.id.security_tv_set_up)
    TextView securityTvSetUp;
    @BindView(R.id.security_tv)
    TextView securityTv;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_security;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
    }

    @OnClick({R.id.security_img_return, R.id.security_fl_control, R.id.security_tv_set_up, R.id.security_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.security_img_return:
                finish();
                break;
            case R.id.security_fl_control:
                goToOtherActivity(VerificationActivity.class, false);
                break;
        }
    }

}
