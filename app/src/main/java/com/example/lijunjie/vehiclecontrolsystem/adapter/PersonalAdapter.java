package com.example.lijunjie.vehiclecontrolsystem.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnItemClickListener;
import com.example.lijunjie.vehiclecontrolsystem.bean.PersonalVehicleBean;

import java.util.List;

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.PersonalViewHolder> {

    private Context mContext;
    private List<PersonalVehicleBean> personalVehicleBeans;
    private OnItemClickListener mOnItemClickListener = null; // 声明接口

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public PersonalAdapter(Context context , List<PersonalVehicleBean> personalVehicleBeanList){
        this.mContext = context;
        this.personalVehicleBeans = personalVehicleBeanList;
    }

    @Override
    public PersonalViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new PersonalViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.personal_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(PersonalViewHolder personalViewHolder, int position) {
        personalViewHolder.vehicle.setText(personalVehicleBeans.get(position).getVehicle());
        personalViewHolder.carModel.setText(personalVehicleBeans.get(position).getCarModel());
        personalViewHolder.carColour.setText(personalVehicleBeans.get(position).getCarColour());

        View itemView = ((RelativeLayout) personalViewHolder.itemView).getChildAt(0);
        if (mOnItemClickListener != null){
            itemView.setOnClickListener(v -> {
                int position1 = personalViewHolder.getLayoutPosition();
                mOnItemClickListener.onItemClick(personalViewHolder.itemView, position1);
            });
        }
    }

    @Override
    public int getItemCount() {
        return personalVehicleBeans.size();
    }

    public class PersonalViewHolder extends RecyclerView.ViewHolder {
        TextView vehicle , carModel , carColour;
        RelativeLayout my_vehicles_deletion;
        public PersonalViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicle = (TextView)itemView.findViewById(R.id.my_vehicles_license_plate);
            carModel = (TextView)itemView.findViewById(R.id.my_vehicles_vehicle_brand);
            carColour = (TextView)itemView.findViewById(R.id.my_vehicles_vehicle_colour);
            my_vehicles_deletion = (RelativeLayout)itemView.findViewById(R.id.my_vehicles_deletion);

        }
    }
}
