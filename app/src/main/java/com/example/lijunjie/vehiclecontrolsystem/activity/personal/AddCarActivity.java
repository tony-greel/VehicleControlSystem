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

public class AddCarActivity extends BaseRequestActivity {
    @BindView(R.id.add_car_img_return) ImageView addCarImgReturn;

    @BindView(R.id.add_car_et_terminal) EditText addCarEtTerminal;

    @BindView(R.id.add_car_img_delete_terminal) ImageView addCarImgDeleteTerminal;

    @BindView(R.id.add_car_et_id) EditText addCarEtId;

    @BindView(R.id.add_car_img_id) ImageView addCarImgId;

    @BindView(R.id.add_car_et_license) EditText addCarEtLicense;

    @BindView(R.id.add_car_img_license) ImageView addCarImgLicense;

    @BindView(R.id.add_car_et_model) EditText addCarEtModel;

    @BindView(R.id.add_car_img_model) ImageView addCarImgModel;

    @BindView(R.id.add_car_et_colour) EditText addCarEtColour;

    @BindView(R.id.add_car_img_colour) ImageView addCarImgColour;
    @BindView(R.id.add_car_but) Button addCarBut;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_add_car;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        InputBoxUtil.initView(addCarEtTerminal,addCarImgDeleteTerminal);
        InputBoxUtil.initView(addCarEtId,addCarImgId);
        InputBoxUtil.initView(addCarEtLicense,addCarImgLicense);
        InputBoxUtil.initView(addCarEtModel,addCarImgModel);
        InputBoxUtil.initView(addCarEtColour,addCarImgColour);
    }

    @OnClick({R.id.add_car_img_return, R.id.add_car_img_delete_terminal, R.id.add_car_img_id, R.id.add_car_img_license, R.id.add_car_img_model, R.id.add_car_img_colour, R.id.add_car_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_car_img_return:
                finish();
                break;
            case R.id.add_car_img_delete_terminal:
                addCarEtTerminal.setText("");
                break;
            case R.id.add_car_img_id:
                addCarEtId.setText("");
                break;
            case R.id.add_car_img_license:
                addCarEtLicense.setText("");
                break;
            case R.id.add_car_img_model:
                addCarEtModel.setText("");
                break;
            case R.id.add_car_img_colour:
                addCarEtColour.setText("");
                break;
            case R.id.add_car_but:
                break;
        }
    }
}
