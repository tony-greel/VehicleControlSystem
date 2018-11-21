package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
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
 * 车辆控制
 */
public class ControlFragment extends BaseFragment implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.control_img_return) ImageView controlImgReturn;
    @BindView(R.id.control_car) ImageView controlCar;
    @BindView(R.id.center_ignition) ImageView centerIgnition;
    @BindView(R.id.center_refrigeration) ImageView centerRefrigeration;
    @BindView(R.id.center_heating) ImageView centerHeating;
    @BindView(R.id.center_progress_bar) SeekBar centerProgressBar;
    @BindView(R.id.center_temperature) TextView centerTemperature;
    @BindView(R.id.center_state) TextView centerState;

    Unbinder unbinder;
    private ListViewAdapter mListViewAdapter;
    private ListView mPopListView;
    private List<MyCarBean> mData=new ArrayList<>();

    @Override
    protected int getLayoutId() { return R.layout.fragment_control; }

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        centerProgressBar.setOnSeekBarChangeListener(this);
        initialization();
    }

    private void initialization() {
        for (int i = 1; i <= 50; i++) {
            MyCarBean myCarBean = new MyCarBean("湘B123TC",R.drawable.itme_cer);
            mData.add(myCarBean);
        }
    }

    @OnClick({R.id.control_img_return, R.id.control_car, R.id.center_ignition,
              R.id.center_refrigeration, R.id.center_heating, R.id.center_temperature, R.id.center_state})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.control_img_return:
                getActivity().finish();
                break;
            case R.id.control_car:
                showPopupWindow();
                break;
            case R.id.center_ignition:
                ControlCipherFragment payDialogFragment_ignition = new ControlCipherFragment();
                payDialogFragment_ignition.show(getActivity().getSupportFragmentManager(), "payFragment");
                break;
            case R.id.center_refrigeration:
                ControlCipherFragment payDialogFragment_refrigeration = new ControlCipherFragment();
                payDialogFragment_refrigeration.show(getActivity().getSupportFragmentManager(), "payFragment");
                break;
            case R.id.center_heating:
                ControlCipherFragment payDialogFragment_heating= new ControlCipherFragment();
                payDialogFragment_heating.show(getActivity().getSupportFragmentManager(), "payFragment");
                break;
            case R.id.center_temperature:
                break;
            case R.id.center_state:
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
        popupWindow.showAsDropDown(controlCar, DisplayUtil.dip2px(getContext(), 50), 15);
        mListViewAdapter = new ListViewAdapter(getContext(),mData,popupWindow);
        mPopListView.setAdapter(mListViewAdapter);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { centerTemperature.setText(progress + "°C"); }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
