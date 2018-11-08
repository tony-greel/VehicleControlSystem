package com.example.lijunjie.vehiclecontrolsystem.activity.fragment;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseRequestFragment;
import com.example.lijunjie.vehiclecontrolsystem.bean.BaseRequestBean;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public class LifeFragment extends BaseRequestFragment implements OnRefreshListener {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_life;
    }

    @Override
    protected void initLayoutView(View view) {

    }

    @Override
    protected void requestDataFromApi() {

    }

    @Override
    protected void onSuccessGetData(BaseRequestBean baseRequestBean) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onNext(Object o) {

    }
}
