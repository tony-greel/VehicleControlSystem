package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 车辆详情
 */
public class CarDetailsActivity extends BaseRequestActivity {
    @BindView(R.id.car_details_img_return)
    ImageView carDetailsImgReturn;
    @BindView(R.id.car_details_delete)
    ImageView carDetailsDelete;
    @BindView(R.id.car_details_sequence)
    EditText carDetailsSequence;
    @BindView(R.id.car_details_frame)
    EditText carDetailsFrame;
    @BindView(R.id.car_details_licence)
    EditText carDetailsLicence;
    @BindView(R.id.car_details_brand)
    EditText carDetailsBrand;
    @BindView(R.id.car_details_colour)
    EditText carDetailsColour;
    @BindView(R.id.car_details_binding)
    Button carDetailsBinding;

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_car_details;
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

    @OnClick({R.id.car_details_img_return, R.id.car_details_delete, R.id.car_details_binding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.car_details_img_return:
                finish();
                break;
            case R.id.car_details_delete:
                break;
            case R.id.car_details_binding:
                break;
        }
    }
}
