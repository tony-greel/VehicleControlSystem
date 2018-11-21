package com.example.lijunjie.vehiclecontrolsystem.activity.fragment;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 地图导航
 */
public class NavigationFragment extends BaseFragment implements LocationSource ,AMapLocationListener,INaviInfoCallback {

    @BindView(R.id.navigation_map) MapView navigationMap;
    @BindView(R.id.navigation_et_search) EditText navigationEtSearch;

    private Unbinder unbinder;
    private Bundle savedInstanceState;
    private AMap navigationAMap;

    //定位功能
    public OnLocationChangedListener mListener;
    public AMapLocationClient mlocationClient;
    public AMapLocationClientOption mLocationOption;

    private int ACCESS_COARSE_LOCATION_CODE = 1;
    private int ACCESS_FINE_LOCATION_CODE = 2;
    private int WRITE_EXTERNAL_STORAGE_CODE = 3;
    private int READ_EXTERNAL_STORAGE_CODE = 4;
    private int READ_PHONE_STATE_CODE = 5;

    @Override
    protected int getLayoutId() { return R.layout.fragment_navigation; }

    @Override
    protected void initLayoutView(View view ) {
        unbinder = ButterKnife.bind(this, view);
        navigationMap.onCreate(savedInstanceState);//显示地图
        initialization();
    }

    private void initialization() {
        if (navigationAMap == null) {
            //SDK在Android 6.0下需要进行运行检测的权限如下：
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //申请WRITE_EXTERNAL_STORAGE权限
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, ACCESS_COARSE_LOCATION_CODE);
            } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_FINE_LOCATION_CODE);
            } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_CODE);
            } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_CODE);
            } else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, READ_PHONE_STATE_CODE);
            }
            navigationAMap = navigationMap.getMap();
            MyLocationStyle locationStyle = new MyLocationStyle();
            locationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.acar));
            navigationAMap.setMyLocationStyle(locationStyle);
            navigationAMap.setLocationSource(this);
            navigationAMap.getUiSettings().setMyLocationButtonEnabled(true);
            navigationAMap.setMyLocationEnabled(true);

            LatLng p3 = new LatLng(39.904556, 116.427231);//北京站
            LatLng p2 = new LatLng(39.917337, 116.397056);//故宫博物院
            AmapNaviParams params = new AmapNaviParams(new Poi("北京站", p3, ""), null, new Poi("故宫博物院", p2, ""), AmapNaviType.DRIVER);
            params.setUseInnerVoice(true);
            AmapNaviPage.getInstance().showRouteActivity(getContext().getApplicationContext(), params, NavigationFragment.this);
        }else {

        }
    }

    /**
     * 加载地图的四个个必要方法
     */
    @Override
    public void onResume(){
        super.onResume();
        navigationMap.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        navigationMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        navigationMap.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        navigationMap.onDestroy();
        if(mlocationClient!=null){
            mlocationClient.onDestroy();
        }
    }

    /**
     * 定位监听的三个必要方法
     * @param amaplocation
     */
    @Override
    public void onLocationChanged(AMapLocation amaplocation) {
        if (amaplocation != null && mListener != null) {
            if (amaplocation != null && amaplocation.getErrorCode() == 0) {
                mListener.onLocationChanged(amaplocation);
            }
            else {
                String errText = "定位失败！！" + amaplocation.getErrorCode()+ ": " + amaplocation.getErrorInfo();
                Log.e("报TM错",errText);
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(getActivity().getApplicationContext());
            mLocationOption = new AMapLocationClientOption();
            mlocationClient.setLocationListener(this);
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mlocationClient.setLocationOption(mLocationOption);
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
        mLocationOption = null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //可在此继续其他操作。
        if (requestCode == ACCESS_COARSE_LOCATION_CODE) {
            Toast.makeText(getActivity().getApplicationContext(), "ACCESS_COARSE_LOCATION_CODE", Toast.LENGTH_LONG).show();
        } else if (requestCode == ACCESS_FINE_LOCATION_CODE) {
            Toast.makeText(getActivity().getApplicationContext(), "ACCESS_FINE_LOCATION_CODE", Toast.LENGTH_LONG).show();
        } else if (requestCode == WRITE_EXTERNAL_STORAGE_CODE) {
            Toast.makeText(getActivity().getApplicationContext(), "WRITE_EXTERNAL_STORAGE_CODE", Toast.LENGTH_LONG).show();
        } else if (requestCode == READ_EXTERNAL_STORAGE_CODE) {
            Toast.makeText(getActivity().getApplicationContext(), "READ_EXTERNAL_STORAGE_CODE", Toast.LENGTH_LONG).show();
        } else if (requestCode == READ_PHONE_STATE_CODE) {
            Toast.makeText(getActivity().getApplicationContext(), "READ_PHONE_STATE_CODE", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onInitNaviFailure() {
    }

    @Override
    public void onGetNavigationText(String s) {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onArriveDestination(boolean b) {

    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onStopSpeaking() {

    }

    @Override
    public void onReCalculateRoute(int i) {

    }

    @Override
    public void onExitPage(int i) {

    }

    @Override
    public void onStrategyChanged(int i) {

    }

    @Override
    public View getCustomNaviBottomView() {
        return null;
    }

    @Override
    public View getCustomNaviView() {
        return null;
    }

    @Override
    public void onArrivedWayPoint(int i) {

    }
}
