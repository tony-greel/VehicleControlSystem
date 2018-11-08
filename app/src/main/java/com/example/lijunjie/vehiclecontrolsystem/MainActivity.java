package com.example.lijunjie.vehiclecontrolsystem;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.HomePageFragment;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.LifeFragment;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.NavigationFragment;
import com.example.lijunjie.vehiclecontrolsystem.activity.fragment.PersonalFragment;
import com.example.lijunjie.vehiclecontrolsystem.adapter.MyPagerAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.activity.BaseActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main) ViewPager vpMain;

    @BindView(R.id.ll_life) LinearLayout llLife;
    @BindView(R.id.ll_navigation) LinearLayout llNavigation;
    @BindView(R.id.ll_discount) LinearLayout llDiscount;
    @BindView(R.id.ll_personal) LinearLayout llPersonal;
    @BindView(R.id.bottom_layout) LinearLayout bottomLayout;

    @BindView(R.id.main_life) ImageView mainLife;
    @BindView(R.id.main_navigation) ImageView mainNavigation;
    @BindView(R.id.main_discount) ImageView mainDiscount;
    @BindView(R.id.main_personal) ImageView mainPersonal;

    @BindView(R.id.main_tv_life) TextView mainTvLife;
    @BindView(R.id.main_tv_map) TextView mainTvMap;
    @BindView(R.id.main_tv_discount) TextView mainTvDiscount;
    @BindView(R.id.main_tv_personal) TextView mainTvPersonal;

    private List<BaseFragment> list;
    private MyPagerAdapter vp_adapter;
    private long firstPressedTime;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViewWithIntentData(Bundle bundle) {
        ButterKnife.bind(this);
        initialization();
    }

    private void initialization() {
        list = new ArrayList<>(4);
        list.add(new HomePageFragment());
        list.add(new NavigationFragment());
        list.add(new LifeFragment());
        list.add(new PersonalFragment());

        vp_adapter = new MyPagerAdapter(getSupportFragmentManager(), list);
//        vpMain.setCurrentItem(0);
        vpMain.setOffscreenPageLimit(5);
        vpMain.setAdapter(vp_adapter);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mainLife.setImageResource(R.drawable.main_life);
                        mainNavigation.setImageResource(R.drawable.main_navigation);
                        mainDiscount.setImageResource(R.drawable.main_discount);
                        mainPersonal.setImageResource(R.drawable.main_personal);
                        mainTvLife.setTextColor(0xFF1D9BDF);
                        mainTvMap.setTextColor(0xFFB4B3B3);
                        mainTvDiscount.setTextColor(0xFFB4B3B3);
                        mainTvPersonal.setTextColor(0xFFB4B3B3);
                        break;
                    case 1:
                        mainLife.setImageResource(R.drawable.img_car);
                        mainNavigation.setImageResource(R.drawable.img_map);
                        mainDiscount.setImageResource(R.drawable.main_discount);
                        mainPersonal.setImageResource(R.drawable.main_personal);
                        mainTvLife.setTextColor(0xFFB4B3B3);
                        mainTvMap.setTextColor(0xFF1D9BDF);
                        mainTvDiscount.setTextColor(0xFFB4B3B3);
                        mainTvPersonal.setTextColor(0xFFB4B3B3);
                        break;
                    case 2:
                        mainLife.setImageResource(R.drawable.img_car);
                        mainNavigation.setImageResource(R.drawable.main_navigation);
                        mainDiscount.setImageResource(R.drawable.img_offer);
                        mainPersonal.setImageResource(R.drawable.main_personal);
                        mainTvLife.setTextColor(0xFFB4B3B3);
                        mainTvMap.setTextColor(0xFFB4B3B3);
                        mainTvDiscount.setTextColor(0xFF1D9BDF);
                        mainTvPersonal.setTextColor(0xFFB4B3B3);
                        break;
                    case 3:
                        mainLife.setImageResource(R.drawable.img_car);
                        mainNavigation.setImageResource(R.drawable.main_navigation);
                        mainDiscount.setImageResource(R.drawable.main_discount);
                        mainPersonal.setImageResource(R.drawable.img_personal);
                        mainTvLife.setTextColor(0xFFB4B3B3);
                        mainTvMap.setTextColor(0xFFB4B3B3);
                        mainTvDiscount.setTextColor(0xFFB4B3B3);
                        mainTvPersonal.setTextColor(0xFF1D9BDF);
                        break;
                }
            }
            @Override
            public void onPageScrolled(int i, float v, int i1) { }
            @Override
            public void onPageScrollStateChanged(int i) { }
        });
    }

    @OnClick({R.id.vp_main, R.id.ll_life, R.id.ll_navigation, R.id.ll_discount, R.id.ll_personal, R.id.bottom_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vp_main:
                break;
            case R.id.ll_life:
                vpMain.setCurrentItem(0);
                break;
            case R.id.ll_navigation:
                vpMain.setCurrentItem(1);
                break;
            case R.id.ll_discount:
                vpMain.setCurrentItem(2);
                break;
            case R.id.ll_personal:
                vpMain.setCurrentItem(3);
                break;
            case R.id.bottom_layout:
                break;
        }
    }

    /**
     * 点击两次退出程序
     */
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - firstPressedTime < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            firstPressedTime = System.currentTimeMillis();
        }
    }

}
