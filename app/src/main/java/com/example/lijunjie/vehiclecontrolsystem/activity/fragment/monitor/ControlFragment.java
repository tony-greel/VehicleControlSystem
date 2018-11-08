package com.example.lijunjie.vehiclecontrolsystem.activity.fragment.monitor;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.fragment.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ControlFragment extends BaseFragment implements SeekBar.OnSeekBarChangeListener {


    @BindView(R.id.control_img_return) ImageView controlImgReturn;
    @BindView(R.id.control_car) ImageView controlCar;
    @BindView(R.id.center_ignition) ImageView centerIgnition;
    @BindView(R.id.center_refrigeration) ImageView centerRefrigeration;
    @BindView(R.id.center_heating) ImageView centerHeating;
    @BindView(R.id.center_progress_bar) SeekBar centerProgressBar;
    @BindView(R.id.center_temperature) TextView centerTemperature;

    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_control;}

    @Override
    protected void initLayoutView(View view) {
        unbinder = ButterKnife.bind(this, view);
        centerProgressBar.setOnSeekBarChangeListener(this);
    }

    @OnClick({R.id.control_img_return, R.id.control_car, R.id.center_ignition, R.id.center_refrigeration, R.id.center_heating, R.id.center_temperature})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.control_img_return:
                getActivity().finish();
                break;
            case R.id.control_car:
                break;
            case R.id.center_ignition:
                break;
            case R.id.center_refrigeration:
                break;
            case R.id.center_heating:
                break;
            case R.id.center_temperature:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        centerTemperature.setText(progress+"°C");
    }

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
