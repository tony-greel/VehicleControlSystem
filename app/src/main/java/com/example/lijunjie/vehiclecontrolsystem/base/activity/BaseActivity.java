package com.example.lijunjie.vehiclecontrolsystem.base.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.interfaces.IBaseActivity;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnDialogClickListener;
import com.example.lijunjie.vehiclecontrolsystem.base.view.LoadingDialog;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener,
        IBaseActivity,OnDialogClickListener {

    private LoadingDialog loadingDialog;

    public Toolbar mToolbar;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initViewWithIntentData(getIntent().getExtras());
    }

    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==android.R.id.home){
            super.onBackPressed();
        }
    }

    @Override
    public void goToOtherActivity(Class<?> cls,boolean isFinish) {
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        if (isFinish){
            finish();
        }
    }

    @Override
    public void goToOtherActivity(Class<?> cls, Bundle bundle,boolean isFinish) {
        Intent intent = new Intent(this,cls);
        intent.putExtras(bundle);
        startActivity(intent);
        if (isFinish)finish();
    }

    @Override
    public void goToOtherActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this,cls);
        intent.putExtras(bundle);
        startActivityForResult(intent,requestCode);
    }

    @Override
    public void backForResult(Class<?> cls, Bundle bundle, int resultCode) {
        Intent intent = new Intent(this,cls);
        intent.putExtras(bundle);
        setResult(resultCode,intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void setToolBar(){
        this.setToolBar(R.id.toolbar);
    }

    public void setToolBar(int toolBarId){
        Toolbar toolbar = findViewById(toolBarId);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            this.mToolbar=toolbar;
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public void setNoBackToolBar(){
        this.setNoBackToolBar(R.id.toolbar);
    }

    public void setNoBackToolBar(int toolBarId){
        Toolbar toolbar = findViewById(toolBarId);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            this.mToolbar=toolbar;
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    public void setHomeResId(int resId){
        ActionBar actionBar = getSupportActionBar();
        if (mToolbar!=null && actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    public void setToolBarTitle(String title){
        if (mToolbar==null){
            setToolBar();
        }
        mToolbar.setTitle(title);
    }

    public void setToolBar(int toolBarId,String title,int homeResId){
        Toolbar toolbar = findViewById(toolBarId);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(title);
            this.mToolbar = toolbar;
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(homeResId);
        }
        mToolbar.setTitle(title);
    }

    public void setToolBarTitle(int titleId){
        if (mToolbar==null){
            setToolBar();
        }
        mToolbar.setTitle(titleId);
    }

    @Override
    public void showLoadingView() {
        if (null != loadingDialog
                && loadingDialog.isShowing()){
            return;
        }else if (null == loadingDialog){
            LoadingDialog.Builder loadBuilder
                    = new LoadingDialog.Builder(this)
                    .setCancelable(true)
                    .setCancelOutside(true);
            loadingDialog =loadBuilder.create();
        }
        loadingDialog.show();
    }

    @Override public void closeLoadingView() {
        if (loadingDialog!=null && loadingDialog.isShowing()){
            loadingDialog.dismiss();
        }
    }

    @Override public void hideInputWindow() {
        View focus = getCurrentFocus();
        if (focus != null) {
            IBinder focusBinder = focus.getWindowToken();
            InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            if (focusBinder != null && manager!=null) {
                manager.hideSoftInputFromWindow(focusBinder, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    @Override public void showInputWindow(EditText mEditText) {
        mEditText.requestFocus();
        InputMethodManager manager = ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE));
        if (manager != null){
            manager.showSoftInput(mEditText, 0);
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onDialogItemClick(boolean isPosition) {

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

    @SuppressLint("NewApi")
    public void setStatusBarColor(int statusColor) {
        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(statusColor));
    }

    public boolean isSoftShowing() {
        int screenHeight = getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return screenHeight - rect.bottom != 0;
    }

}
