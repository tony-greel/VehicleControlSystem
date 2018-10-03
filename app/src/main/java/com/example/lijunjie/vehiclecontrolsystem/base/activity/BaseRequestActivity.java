package com.example.lijunjie.vehiclecontrolsystem.base.activity;

import android.os.Bundle;
import android.view.Menu;
import com.example.lijunjie.vehiclecontrolsystem.base.util.ToastHelper;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseRequestActivity<L> extends BaseActivity implements Observer<L> {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isOnCreateRequest()){
            startRequest();
        }
    }

    public void startRequest(){
        if (validationInput()){
            showLoadingView();
            requestDataFromApi();
        }
    }

    protected boolean validationInput(){
        return true;
    }

    protected abstract void requestDataFromApi();

    protected abstract void onSuccessGetData(L t);

    protected void onFailGetData(Throwable e){
        ToastHelper.toast(e.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable!=null && !disposable.isDisposed()){
            disposable.dispose();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.disposable = d;
    }

    @Override
    public void onNext(L l) {
        onSuccessGetData(l);
    }

    @Override
    public void onError(Throwable e) {
        onFailGetData(e);
        closeLoadingView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenuId()!=-1){
            getMenuInflater().inflate(getMenuId(),menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public int getMenuId() {
        return -1;
    }

    @Override
    public void onComplete() {
        closeLoadingView();
    }

    public boolean isOnCreateRequest() {
        return true;
    }
}
