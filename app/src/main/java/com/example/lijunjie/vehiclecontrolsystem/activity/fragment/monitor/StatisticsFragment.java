package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.adapter.ListViewAdapter;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.base.util.DisplayUtil;
import com.example.lijunjie.vehiclecontrolsystem.base.view.DiscView;
import com.example.lijunjie.vehiclecontrolsystem.bean.Databean;
import com.example.lijunjie.vehiclecontrolsystem.bean.MyCarBean;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 数据统计
 */
public class StatisticsFragment extends BaseFragment {

    @BindView(R.id.statistics_img_return) ImageView statisticsImgReturn;
    @BindView(R.id.statistics_time_car) ImageView statisticsTimeCar;
    @BindView(R.id.statistics_disc) DiscView statisticsDisc;

    Unbinder unbinder;
    private ListViewAdapter mListViewAdapter;
    private ListView mPopListView;
    private List<MyCarBean> mData=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_statistics;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        loadData();
        initialization();

    }

    private void initialization() {
        for (int i = 1; i <= 50; i++) {
            MyCarBean myCarBean = new MyCarBean("湘B123TC",R.drawable.itme_cer);
            mData.add(myCarBean);
        }
    }

    @SuppressLint("NewApi")
    private void loadData() {
        List<Databean> items = new ArrayList<>();
        items.add(new Databean(4,"油量","26.56",getActivity().getColor(R.color.dark_grey)));
        items.add(new Databean(14,"电量","32.45",getActivity().getColor(R.color.green)));
        items.add(new Databean(24,"总里程","12.36",getActivity().getColor(R.color.rl_background_two)));
        items.add(new Databean(33,"车胎压力","56.23",getActivity().getColor(R.color.rl_background)));
        items.add(new Databean(4,"空调","45.56",getActivity().getColor(R.color.red)));
        items.add(new Databean(55,"车灯","45.56",getActivity().getColor(R.color.blue)));
        items.add(new Databean(64,"故障报修","45.56",getActivity().getColor(R.color.black)));
        items.add(new Databean(74,"围栏报警","45.56",getActivity().getColor(R.color.dialog_box_determine_background)));
//        items.add(new DataItem(4,"虎牙","45.56",getColor(R.color.yellow)));
//        items.add(new DataItem(24,"京东","35.56",getColor(R.color.green)));
//        items.add(new DataItem(23,"Windows","37.25",getColor(R.color.yellow)));
//        items.add(new DataItem(12,"头条","334.25",getColor(R.color.blue)));
//        items.add(new DataItem(13,"IBM","37.25",getColor(R.color.black)));
//        items.add(new DataItem(2,"甲骨文","30.25",getColor(R.color.yellow)));
        statisticsDisc.setItems(items);
    }

    @OnClick({R.id.statistics_img_return, R.id.statistics_time_car})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.statistics_img_return:
                getActivity().finish();
                break;
            case R.id.statistics_time_car:
                showPopupWindow();
                break;
        }
    }

    private void showPopupWindow() {
        View view = View.inflate(getContext(), R.layout.popup_window, null);
        mPopListView = (ListView) view.findViewById(R.id.pop_list_view);

        PopupWindow popupWindow = new PopupWindow(view, DisplayUtil.dip2px(getContext(), 150),
                DisplayUtil.dip2px(getContext(), 240), true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.update();
        popupWindow.showAsDropDown(statisticsTimeCar, DisplayUtil.dip2px(getContext(), 50), 15);
        mListViewAdapter = new ListViewAdapter(getContext(),mData,popupWindow);
        mPopListView.setAdapter(mListViewAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
