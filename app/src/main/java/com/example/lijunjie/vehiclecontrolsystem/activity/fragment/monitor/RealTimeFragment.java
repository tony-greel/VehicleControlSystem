package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_real_time;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        realTimeMap.onCreate(savedInstanceState);//显示地图
    }

    @OnClick({R.id.real_time_img_return, R.id.real_time_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.real_time_img_return:
                getActivity().finish();
                break;
            case R.id.real_time_car:
                break;
        }
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
