package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.adapter.ListViewAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.base.util.DisplayUtil;
import com.example.lijunjie.vehiclecontrolsystem.bean.MyCarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 实时监控
 */
public class RealTimeFragment extends BaseFragment {

    @BindView(R.id.real_time_img_return) ImageView realTimeImgReturn;
    @BindView(R.id.real_time_car) ImageView realTimeCar;
    @BindView(R.id.real_time_map) TextureMapView realTimeMap;

    private Unbinder unbinder;
    private Bundle savedInstanceState;
    private AMap realTimeAMap;
    private ListViewAdapter mListViewAdapter;
    private ListView mPopListView;
    private List<MyCarBean> mData=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_real_time;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        realTimeMap.onCreate(savedInstanceState);//显示地图
        initialization();
    }

    private void initialization() {
        for (int i = 1; i <= 50; i++) {
            MyCarBean myCarBean = new MyCarBean("湘B123TC",R.drawable.itme_cer);
            mData.add(myCarBean);
        }
    }

    @OnClick({R.id.real_time_img_return, R.id.real_time_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.real_time_img_return:
                getActivity().finish();
                break;
            case R.id.real_time_car:
                showPopupWindow();
                break;
        }
    }

    private void showPopupWindow() {
        View view = View.inflate(getContext(), R.layout.popup_window, null);
        mPopListView = (ListView) view.findViewById(R.id.pop_list_view);

        PopupWindow popupWindow = new PopupWindow(view,
                DisplayUtil.dip2px(getContext(), 150),
                DisplayUtil.dip2px(getContext(), 240), true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.update();
        popupWindow.showAsDropDown(realTimeCar, DisplayUtil.dip2px(getContext(), 50), 15);
        mListViewAdapter = new ListViewAdapter(getContext(),mData,popupWindow);
        mPopListView.setAdapter(mListViewAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 以下四个方法必须重写
     */
    @Override
    public void onResume() {
        Log.i("sys", "mf onResume");
        super.onResume();
        realTimeMap.onResume();
    }

    @Override
    public void onPause() {
        Log.i("sys", "mf onPause");
        super.onPause();
        realTimeMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("sys", "mf onSaveInstanceState");
        super.onSaveInstanceState(outState);
        realTimeMap.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        Log.i("sys", "mf onDestroy");
        super.onDestroy();

    }
}
