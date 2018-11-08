package com.example.lijunjie.vehiclecontrolsystem.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lijunjie.vehiclecontrolsystem.MonitorActivity;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.activity.ForgetPasswordActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.model.HomePageModel;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomePageFragment extends BaseFragment {

    @BindView(R.id.main_share) ImageView mainShare;
    @BindView(R.id.home_page_banner) Banner homePageBanner;

    @BindView(R.id.home_page_monitor) LinearLayout homePageMonitor;
    @BindView(R.id.home_page_navigation) LinearLayout homePageNavigation;
    @BindView(R.id.home_page_enclosure) LinearLayout homePageEnclosure;
    @BindView(R.id.home_page_record) LinearLayout homePageRecord;

    @BindView(R.id.home_page_condition) LinearLayout homePageCondition;
    @BindView(R.id.home_page_behavior) LinearLayout homePageBehavior;
    @BindView(R.id.home_page_consumption) LinearLayout homePageConsumption;
    @BindView(R.id.home_page_drive) LinearLayout homePageDrive;

    @BindView(R.id.home_page_query) LinearLayout homePageQuery;
    @BindView(R.id.home_page_traffic) LinearLayout homePageTraffic;
    @BindView(R.id.home_page_insurance) LinearLayout homePageInsurance;
    @BindView(R.id.home_page_more) LinearLayout homePageMore;

    Unbinder unbinder;
    private List<Integer> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        HomePageModel.advertisement(homePageBanner, list);
    }

    @OnClick({R.id.main_share, R.id.home_page_banner, R.id.home_page_monitor, R.id.home_page_navigation, R.id.home_page_enclosure, R.id.home_page_record, R.id.home_page_condition, R.id.home_page_behavior, R.id.home_page_consumption, R.id.home_page_drive, R.id.home_page_query, R.id.home_page_traffic, R.id.home_page_insurance, R.id.home_page_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_share:
                break;
            case R.id.home_page_banner:
                break;
            case R.id.home_page_monitor:
                goToOtherActivity(MonitorActivity.class, false);
                break;
            case R.id.home_page_navigation:
                break;
            case R.id.home_page_enclosure:
                break;
            case R.id.home_page_record:
                break;
            case R.id.home_page_condition:
                break;
            case R.id.home_page_behavior:
                break;
            case R.id.home_page_consumption:
                break;
            case R.id.home_page_drive:
                break;
            case R.id.home_page_query:
                break;
            case R.id.home_page_traffic:
                break;
            case R.id.home_page_insurance:
                break;
            case R.id.home_page_more:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
