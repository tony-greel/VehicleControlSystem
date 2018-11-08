package com.example.lijunjie.vehiclecontrolsystem.activity.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.AboutActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.CarControlActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.FeedbackActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.IdActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.MessageActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.MyCarActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.PhoneActivity;
import com.example.lijunjie.vehiclecontrolsystem.activity.personal.account.SecurityActivity;
import com.example.lijunjie.vehiclecontrolsystem.adapter.PersonalAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnItemClickListener;
import com.example.lijunjie.vehiclecontrolsystem.bean.PersonalVehicleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PersonalFragment extends BaseFragment {

    @BindView(R.id.personal_img_head_portrait) ImageView personalImgHeadPortrait;
    @BindView(R.id.personal_tv) TextView personalTv;
    @BindView(R.id.personal_chat) ImageView personalChat;
    @BindView(R.id.personal_toolbar) Toolbar personalToolbar;
    @BindView(R.id.personal_img_forward) ImageView personalImgForward;
    @BindView(R.id.personal_rv_vehicle) RecyclerView personalRvVehicle;
    @BindView(R.id.personal_fl_security) FrameLayout personalFlSecurity;
    @BindView(R.id.personal_fl_control) FrameLayout personalFlControl;
    @BindView(R.id.personal_fl_id) FrameLayout personalFlId;
    @BindView(R.id.personal_fl_phone) FrameLayout personalFlPhone;
    @BindView(R.id.personal_fl_feedback) FrameLayout personalFlFeedback;
    @BindView(R.id.personal_fl_about) FrameLayout personalFlAbout;
    @BindView(R.id.personal_fl_rv) FrameLayout personalFlRv;

    Unbinder unbinder;
    private List<PersonalVehicleBean> personalVehicleBeanList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        initialization();
    }

    private void initialization() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);// 设置布局方式为横向布局
        personalRvVehicle.setLayoutManager(linearLayoutManager);
        PersonalAdapter adapter = new PersonalAdapter(getContext(), personalVehicleBeanList);
        personalRvVehicle.setAdapter(adapter);

        for (int i = 0; i < 12; i++) {
            PersonalVehicleBean personalVehicleBean = new PersonalVehicleBean("湘B123AD", "大众辉腾", "白色");
            personalVehicleBeanList.add(personalVehicleBean);
        }
        adapter.setOnItemClickListener((itemData, position) -> goToOtherActivity(MyCarActivity.class, false));
    }

    @OnClick({R.id.personal_img_head_portrait, R.id.personal_chat, R.id.personal_img_forward,
            R.id.personal_fl_security, R.id.personal_fl_control, R.id.personal_fl_id,
            R.id.personal_fl_phone, R.id.personal_fl_feedback, R.id.personal_fl_about,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_img_head_portrait:
                break;
            case R.id.personal_chat:
                goToOtherActivity(MessageActivity.class, false);
                break;
            case R.id.personal_img_forward:
                Toast.makeText(mBaseActivity, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_fl_security:
                goToOtherActivity(SecurityActivity.class, false);
                break;
            case R.id.personal_fl_control:
                goToOtherActivity(CarControlActivity.class, false);
                break;
            case R.id.personal_fl_id:
                goToOtherActivity(IdActivity.class, false);
                break;
            case R.id.personal_fl_phone:
                goToOtherActivity(PhoneActivity.class, false);
                break;
            case R.id.personal_fl_feedback:
                goToOtherActivity(FeedbackActivity.class, false);
                break;
            case R.id.personal_fl_about:
                goToOtherActivity(AboutActivity.class, false);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
