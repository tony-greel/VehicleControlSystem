package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.base.util.DateTimeHelper;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 历史轨迹
 */
public class HistoryFragment extends BaseFragment {

    @BindView(R.id.history_img_return) ImageView historyImgReturn;
    @BindView(R.id.history_car) ImageView historyCar;
    @BindView(R.id.history_map) TextureMapView historyMap;
    @BindView(R.id.history_date) TextView historyDate;
    @BindView(R.id.history_query) TextView historyQuery;

    private Unbinder unbinder;
    private Bundle savedInstanceState;
    private AMap historyAMap;
    private TimePickerView mStartDatePickerView;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        historyMap.onCreate(savedInstanceState);//显示地图
        initStartTimePicker();
        initEvents();
    }

    @OnClick({R.id.history_img_return, R.id.history_car, R.id.history_map, R.id.history_date, R.id.history_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.history_img_return:
                getActivity().finish();
                break;
            case R.id.history_car:
                break;
            case R.id.history_map:
                break;
            case R.id.history_date:
                break;
            case R.id.history_query:
                break;
        }
    }

    /**初始化开始日期选择器控件*/
    private void initStartTimePicker() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        //设置最小日期和最大日期
        Calendar startDate = Calendar.getInstance();
        try {
            startDate.setTime(DateTimeHelper.parseStringToDate("1970-01-01"));//设置为2006年4月28日
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar endDate = Calendar.getInstance();//最大日期是今天

        //时间选择器
        mStartDatePickerView = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                historyDate.setText(DateTimeHelper.formatToString(date,"yyyy-MM-dd"));
            }
        })
                .setDecorView((RelativeLayout)getActivity().findViewById(R.id.activity_rootview))//必须是RelativeLayout，不设置setDecorView的话，底部虚拟导航栏会显示在弹出的选择器区域
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("", "", "", "", "", "")
                .isCenterLabel(false)//是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setTitleText("开始日期")//标题文字
                .setTitleSize(20)//标题文字大小
                .setTitleColor(getResources().getColor(R.color.pickerview_title_text_color))//标题文字颜色
                .setCancelText("取消")//取消按钮文字
                .setCancelColor(getResources().getColor(R.color.pickerview_cancel_text_color))//取消按钮文字颜色
                .setSubmitText("确定")//确认按钮文字
                .setSubmitColor(getResources().getColor(R.color.pickerview_submit_text_color))//确定按钮文字颜色
                .setContentTextSize(20)//滚轮文字大小
                .setTextColorCenter(getResources().getColor(R.color.pickerview_center_text_color))//设置选中文本的颜色值
                .setLineSpacingMultiplier(1.8f)//行间距
                .setDividerColor(getResources().getColor(R.color.pickerview_divider_color))//设置分割线的颜色
                .setRangDate(startDate, endDate)//设置最小和最大日期
                .setDate(selectedDate)//设置选中的日期
                .build();
    }

    private void initEvents() {
        //开始日期的下拉菜单点击事件
        historyDate.setOnClickListener(view -> mStartDatePickerView.show());
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
        historyMap.onResume();
    }

    @Override
    public void onPause() {
        Log.i("sys", "mf onPause");
        super.onPause();
        historyMap.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("sys", "mf onSaveInstanceState");
        super.onSaveInstanceState(outState);
        historyMap.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        Log.i("sys", "mf onDestroy");
        super.onDestroy();

    }
}
