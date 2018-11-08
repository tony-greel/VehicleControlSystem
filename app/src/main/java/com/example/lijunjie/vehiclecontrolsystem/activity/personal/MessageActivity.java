package com.example.lijunjie.vehiclecontrolsystem.activity.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 消息界面
 */
public class MessageActivity extends BaseRequestActivity {

    @BindView(R.id.message_img_return)
    ImageView messageImgReturn;
    @BindView(R.id.message_fire)
    Switch messageFire;
    @BindView(R.id.message_fault)
    Switch messageFault;
    @BindView(R.id.message_collision)
    Switch messageCollision;
    @BindView(R.id.message_speeding)
    Switch messageSpeeding;
    @BindView(R.id.message_insurance)
    Switch messageInsurance;
    @BindView(R.id.message_activity)
    Switch messageActivity;
    @BindView(R.id.message_remind)
    Switch messageRemind;
    @BindView(R.id.message_navigation)
    Switch messageNavigation;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_message;
    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(Object t) {

    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
    }

    @OnClick({R.id.message_img_return, R.id.message_fire, R.id.message_fault, R.id.message_collision, R.id.message_speeding, R.id.message_insurance, R.id.message_activity, R.id.message_remind, R.id.message_navigation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.message_img_return:
                finish();
                break;
            case R.id.message_fire:
                break;
            case R.id.message_fault:
                break;
            case R.id.message_collision:
                break;
            case R.id.message_speeding:
                break;
            case R.id.message_insurance:
                break;
            case R.id.message_activity:
                break;
            case R.id.message_remind:
                break;
            case R.id.message_navigation:
                break;
        }
    }
}
