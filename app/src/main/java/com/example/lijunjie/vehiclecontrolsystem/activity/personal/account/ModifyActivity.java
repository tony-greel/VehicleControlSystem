package com.example.lijunjie.vehiclecontrolsystem.activity.personal.account;

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

/**
 * 修改密码
 */
public class ModifyActivity extends BaseRequestActivity {


    @BindView(R.id.modify_img_return)
    ImageView modifyImgReturn;
    @BindView(R.id.modify_et_password)
    EditText modifyEtPassword;
    @BindView(R.id.modify_img_delete_password)
    ImageView modifyImgDeletePassword;
    @BindView(R.id.modify_img_close_password)
    ImageView modifyImgClosePassword;
    @BindView(R.id.modify_et_code)
    EditText modifyEtCode;
    @BindView(R.id.modify_img_password)
    ImageView modifyImgPassword;
    @BindView(R.id.modify_img_close)
    ImageView modifyImgClose;
    @BindView(R.id.modify_preservation)
    Button modifyPreservation;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_modify;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(modifyEtPassword,modifyImgDeletePassword);
        InputBoxUtil.initView(modifyEtCode,modifyImgPassword);
    }

    @OnClick({R.id.modify_img_return, R.id.modify_img_delete_password, R.id.modify_img_close_password, R.id.modify_img_password, R.id.modify_img_close, R.id.modify_preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modify_img_return:
                finish();
                break;
            case R.id.modify_img_delete_password:
                modifyEtPassword.setText("");
                break;
            case R.id.modify_img_close_password:
                InputBoxUtil.imgPasswordDisappearMonitorColour(modifyEtPassword,modifyImgClosePassword);
                break;
            case R.id.modify_img_password:
                modifyEtCode.setText("");
                break;
            case R.id.modify_img_close:
                InputBoxUtil.imgPasswordDisappearMonitorColour(modifyEtCode,modifyImgClose);
                break;
            case R.id.modify_preservation:
                break;
        }
    }
}
