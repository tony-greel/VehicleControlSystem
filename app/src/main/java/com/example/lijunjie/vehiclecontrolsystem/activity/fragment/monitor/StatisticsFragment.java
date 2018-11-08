package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import com.example.lijunjie.vehiclecontrolsystem.base.view.DiscView;
import com.example.lijunjie.vehiclecontrolsystem.bean.Databean;
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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_statistics;
    }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        loadData();
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
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
