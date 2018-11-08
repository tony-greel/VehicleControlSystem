package com.example.lijunjie.vehiclecontrolsystem;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor.ControlFragment;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor.HistoryFragment;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor.RealTimeFragment;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor.StatisticsFragment;
import com.example.lijunjie.vehiclecontrolsystem.adapter.MyPagerAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.base.view.MonitorViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MonitorActivity extends BaseActivity {

    @BindView(R.id.monitor_real_time) ImageView monitorRealTime;
    @BindView(R.id.monitor_tv_real_time) TextView monitorTvRealTime;
    @BindView(R.id.ll_real_time) LinearLayout llRealTime;
    @BindView(R.id.monitor_navigation) ImageView monitorNavigation;
    @BindView(R.id.monitor_tv_history) TextView monitorTvHistory;
    @BindView(R.id.ll_history) LinearLayout llHistory;
    @BindView(R.id.monitor_discount) ImageView monitorDiscount;
    @BindView(R.id.monitor_tv_statistics) TextView monitorTvStatistics;
    @BindView(R.id.ll_statistics) LinearLayout llStatistics;
    @BindView(R.id.monitor_personal) ImageView monitorPersonal;
    @BindView(R.id.monitor_tv_control) TextView monitorTvControl;
    @BindView(R.id.ll_control) LinearLayout llControl;

    @BindView(R.id.monitor_viewpager) MonitorViewPager monitorViewpager;

    private List<BaseFragment> list;
    private MyPagerAdapter vp_adapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_monitor;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        list = new ArrayList<>(4);
        list.add(new RealTimeFragment());
        list.add(new HistoryFragment());
        list.add(new StatisticsFragment());
        list.add(new ControlFragment());

        vp_adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
//        vpMain.setCurrentItem(0);
        monitorViewpager.setOffscreenPageLimit(5);
        monitorViewpager.setScanScroll(false);
        monitorViewpager.setAdapter(vp_adapter);
        monitorViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        monitorRealTime.setImageResource(R.drawable.monitor_real_time_after);
                        monitorNavigation.setImageResource(R.drawable.monitor_history);
                        monitorDiscount.setImageResource(R.drawable.monitor_statistics);
                        monitorPersonal.setImageResource(R.drawable.monitor_control);
                        monitorTvRealTime.setTextColor(0xFF1D9BDF);
                        monitorTvHistory.setTextColor(0xFFB4B3B3);
                        monitorTvStatistics.setTextColor(0xFFB4B3B3);
                        monitorTvControl.setTextColor(0xFFB4B3B3);
                        break;
                    case 1:
                        monitorRealTime.setImageResource(R.drawable.monitor_real_time);
                        monitorNavigation.setImageResource(R.drawable.monitor_history_after);
                        monitorDiscount.setImageResource(R.drawable.monitor_statistics);
                        monitorPersonal.setImageResource(R.drawable.monitor_control);
                        monitorTvRealTime.setTextColor(0xFFB4B3B3);
                        monitorTvHistory.setTextColor(0xFF1D9BDF);
                        monitorTvStatistics.setTextColor(0xFFB4B3B3);
                        monitorTvControl.setTextColor(0xFFB4B3B3);
                        break;
                    case 2:
                        monitorRealTime.setImageResource(R.drawable.monitor_real_time);
                        monitorNavigation.setImageResource(R.drawable.monitor_history);
                        monitorDiscount.setImageResource(R.drawable.monitor_statistics_after);
                        monitorPersonal.setImageResource(R.drawable.monitor_control);
                        monitorTvRealTime.setTextColor(0xFFB4B3B3);
                        monitorTvHistory.setTextColor(0xFFB4B3B3);
                        monitorTvStatistics.setTextColor(0xFF1D9BDF);
                        monitorTvControl.setTextColor(0xFFB4B3B3);
                        break;
                    case 3:
                        monitorRealTime.setImageResource(R.drawable.monitor_real_time);
                        monitorNavigation.setImageResource(R.drawable.monitor_history);
                        monitorDiscount.setImageResource(R.drawable.monitor_statistics);
                        monitorPersonal.setImageResource(R.drawable.monitor_control_after);
                        monitorTvRealTime.setTextColor(0xFFB4B3B3);
                        monitorTvHistory.setTextColor(0xFFB4B3B3);
                        monitorTvStatistics.setTextColor(0xFFB4B3B3);
                        monitorTvControl.setTextColor(0xFF1D9BDF);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    @OnClick({R.id.monitor_viewpager, R.id.ll_real_time, R.id.ll_history, R.id.ll_statistics, R.id.ll_control})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.monitor_viewpager:
                break;
            case R.id.ll_real_time:
                monitorViewpager.setCurrentItem(0);
                break;
            case R.id.ll_history:
                monitorViewpager.setCurrentItem(1);
                break;
            case R.id.ll_statistics:
                monitorViewpager.setCurrentItem(2);
                break;
            case R.id.ll_control:
                monitorViewpager.setCurrentItem(3);
                break;
        }
    }

}
