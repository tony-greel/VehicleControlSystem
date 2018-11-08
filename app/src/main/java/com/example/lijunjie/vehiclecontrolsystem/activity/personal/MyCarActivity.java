package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.account.VerificationActivity;
import com.example.lijunjie.vehiclecontrolsystem.adapter.PersonalAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnItemClickListener;
import com.example.lijunjie.vehiclecontrolsystem.bean.PersonalVehicleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的车辆
 */
public class MyCarActivity extends BaseRequestActivity {

    @BindView(R.id.my_car_img_return)
    ImageView myCarImgReturn;
    @BindView(R.id.my_car_share)
    ImageView myCarShare;
    @BindView(R.id.my_car_recyclerView)
    RecyclerView myCarRecyclerView;

    private List<PersonalVehicleBean> personalVehicleBeanList = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_car;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        myCarRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        PersonalAdapter  personalAdapter = new PersonalAdapter(this,personalVehicleBeanList);
        myCarRecyclerView.setAdapter(personalAdapter);

        for (int i = 0 ; i < 10; i++){
            PersonalVehicleBean personalVehicleBean = new PersonalVehicleBean("湘B123AD", "大众辉腾", "白色");
            personalVehicleBeanList.add(personalVehicleBean);
        }

        personalAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Object itemData, int position) {
                goToOtherActivity(CarDetailsActivity.class, false);
            }
        });
    }

    @OnClick({R.id.my_car_img_return, R.id.my_car_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_car_img_return:
                finish();
                break;
            case R.id.my_car_share:
                goToOtherActivity(AddCarActivity.class, false);
                break;
        }
    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }
}
