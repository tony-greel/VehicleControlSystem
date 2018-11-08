package com.example.lijunjie.vehiclecontrolsystem.base.fragment;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.example.lijunjie.vehiclecontrolsystem.base.adapter.BaseRecycleAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.adapter.viewholder.BaseViewHolder;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnItemClickListener;
import com.example.lijunjie.vehiclecontrolsystem.base.util.ToastHelper;
import com.example.lijunjie.vehiclecontrolsystem.bean.BaseRequestBean;
import com.example.lijunjie.vehiclecontrolsystem.hbrd.Constant;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseListFragment<T,B extends BaseRequestBean,VH extends BaseViewHolder<T>>
        extends BaseFragment implements OnRefreshListener,OnLoadMoreListener,Observer<B> ,OnItemClickListener<T> {

    private Disposable disposable;
    private RecyclerView recyclerView;
    private static final int delay = 1500;
    private SmartRefreshLayout mRefreshLayout;
    private int pageStart = 1;
    private int page = pageStart;
    private BaseRecycleAdapter<T,VH> adapter;
    //用于区分没有更多内容时停止加载更多和单纯的禁止加载更多
    private boolean enableLoadMore = true;
    private boolean isNeedLoad = false;


    private void startRequest(){
     if (mRefreshLayout != null){
         mRefreshLayout.setOnRefreshListener(this);
         mRefreshLayout.setOnLoadMoreListener(this);
         if(getUserVisibleHint()){
             mRefreshLayout.autoRefresh();
         }else {
             isNeedLoad = true;
         }
     }
    }

    protected void initRecyclerView(View view) {
        recyclerView = view.findViewById(getRecycleViewId());
        mRefreshLayout = view.findViewById(getRefreshLayoutId());
        adapter = getRecycleAdapter();
        adapter.setOnItemClickListener(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(adapter);
    }

    private void remakePage() {
        mRefreshLayout.setEnableLoadMore(enableLoadMore);
        page = pageStart;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mBaseActivity);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void loadMoreFinish(List<T> data){
        if (page == pageStart){
            if (null != data){
                adapter.setDataList(data);
            }
            mRefreshLayout.finishRefresh();
        }else {
            if (null != data && data.size()>0){
                adapter.appendDataToList(data);
            }else if (null != data){
                mRefreshLayout.setEnableLoadMore(false);
            }
            mRefreshLayout.finishLoadMore();
        }
        page++;
    }

    public void stopRefreshing(){
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadMore(0);
    }

    protected abstract BaseRecycleAdapter<T,VH> getRecycleAdapter();

    protected abstract int getRefreshLayoutId();

    protected abstract int getRecycleViewId();

    protected abstract void requestListData(int page);

    protected abstract List<T> getData(B b);

    /**
     * 加载视图
     * @param view
     */
    @Override
    protected void initLayoutView(View view) {
        initRecyclerView(view);
        startRequest();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()&&isNeedLoad){
            isNeedLoad = false;
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        requestListData(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        remakePage();
        requestListData(page);
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(B b) {
        if (b.getCode() == Constant.REQUEST_SUCCESS){
            loadMoreFinish(getData(b));
        }else if (!TextUtils.isEmpty(b.getMsg())){
            ToastHelper.toast(b.getMsg());
        }else {
            ToastHelper.toast(String.valueOf(b.getCode()));
        }
    }

    @Override
    public void onError(Throwable e) {
        startRequest();
        ToastHelper.toast(e.getMessage());
    }

    @Override
    public void onComplete() {
        stopRefreshing();
    }

    @Override
    public void onItemClick(T itemData, int position) {

    }
}
