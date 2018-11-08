package com.example.lijunjie.vehiclecontrolsystem.base.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lijunjie.vehiclecontrolsystem.base.adapter.viewholder.BaseViewHolder;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnItemClickListener;
import com.example.lijunjie.vehiclecontrolsystem.base.listener.OnItemLongClickListener;
import com.example.lijunjie.vehiclecontrolsystem.hbrd.LogHbrd;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BaseRecycleAdapter <T , V extends BaseViewHolder<T>> extends RecyclerView.Adapter<V> {

    protected List<T> dataList;

    private int layoutId;

    private OnItemClickListener<T> onItemClickListener;
    private OnItemLongClickListener<T> onItemLongClickListener;

    private Context mContext;
    private Class<V> vHclass;

    public BaseRecycleAdapter(List<T> dataList , int layoutId , Class<V> vClass){
        this.dataList = dataList;
        this.layoutId = layoutId;
        this.vHclass = vClass;
    }

    @SuppressLint("NewApi")
    @Override
    public V onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (mContext == null)mContext = viewGroup.getContext();
        try{
            Constructor<V> constructor = vHclass.getConstructor(View.class);
            return constructor.newInstance(newItemView(viewGroup,layoutId));
        } catch ( NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            LogHbrd.log("反射失败");
        }
        return null;
    }

    private View newItemView(ViewGroup viewGroup , int resId){
        return LayoutInflater.from(viewGroup.getContext()).inflate(resId,viewGroup,false);
    }

    @Override
    public void onBindViewHolder(V baseViewHolder, int i) {
        baseViewHolder.setData(dataList.get(i));
        baseViewHolder.loadItemData(mContext,dataList.get(i),i);
        if (onItemClickListener!=null){
            baseViewHolder.itemView.setOnClickListener(v
                    ->onItemClickListener.onItemClick(dataList.get(i),i));
        }
        if (onItemLongClickListener!=null){
            baseViewHolder.itemView.setOnLongClickListener(v->
                    onItemLongClickListener.onItemLongClick(dataList.get(i),i));
        }
    }

    @Override
    public int getItemCount() {
        return dataList==null ? 0:dataList.size();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(
            OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 用于下la
     * @param dataList
     */
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * 用于上拉加载更多更新界面
     * @param datas
     */
    public void appendDataToList(List<T> datas){
        int firstPosition = getItemCount();
        dataList.addAll(datas);
        int lastPosition = getItemCount();
        for (int i = firstPosition; i < lastPosition; i++) {
            notifyItemInserted(i);
        }
    }
}
