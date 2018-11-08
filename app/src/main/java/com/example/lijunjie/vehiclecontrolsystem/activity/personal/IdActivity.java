package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

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
 * 身份证
 */
public class IdActivity extends BaseRequestActivity {

    @BindView(R.id.id_img_return)
    ImageView idImgReturn;
    @BindView(R.id.id_et_name)
    EditText idEtName;
    @BindView(R.id.id_img_name)
    ImageView idImgName;
    @BindView(R.id.id_et_sex)
    EditText idEtSex;
    @BindView(R.id.id_et_id)
    EditText idEtId;
    @BindView(R.id.id_img_id)
    ImageView idImgId;
    @BindView(R.id.id_preservation)
    Button idPreservation;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_id;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(idEtName,idImgName);
        InputBoxUtil.initView(idEtId,idImgId);
    }

    @OnClick({R.id.id_img_return, R.id.id_img_name, R.id.id_img_id, R.id.id_preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_img_return:
                finish();
                break;
            case R.id.id_img_name:
                idEtName.setText("");
                break;
            case R.id.id_img_id:
                idEtId.setText("");
                break;
            case R.id.id_preservation:
                break;
        }
    }
}
