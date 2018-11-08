package com.example.lijunjie.vehiclecontrolsystem.activity.personal.account;
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
 * 验证手机
 */
public class VerificationActivity extends BaseRequestActivity {
    @BindView(R.id.verification_img_return)
    ImageView verificationImgReturn;
    @BindView(R.id.verification_et_phone)
    EditText verificationEtPhone;
    @BindView(R.id.verification_img_delete_phone)
    ImageView verificationImgDeletePhone;
    @BindView(R.id.verification_et_code)
    EditText verificationEtCode;
    @BindView(R.id.verification_tv_code)
    TextView verificationTvCode;
    @BindView(R.id.verification_preservation)
    Button verificationPreservation;

    @Override
    protected void requestDataFromApi() {
    }

    @Override
    protected void onSuccessGetData(Object t) {
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_verification;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(verificationEtPhone,verificationImgDeletePhone);
    }

    @OnClick({R.id.verification_img_return, R.id.verification_img_delete_phone, R.id.verification_tv_code, R.id.verification_preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.verification_img_return:
                finish();
                break;
            case R.id.verification_img_delete_phone:
                verificationEtPhone.setText("");
                break;
            case R.id.verification_tv_code:
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(verificationTvCode, 60000, 1000);
                mCountDownTimerUtils.start();
                break;
            case R.id.verification_preservation:
                goToOtherActivity(ModifyActivity.class, false);
                break;
        }
    }
}
