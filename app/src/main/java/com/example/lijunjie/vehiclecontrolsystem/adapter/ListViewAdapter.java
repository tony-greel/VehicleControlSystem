package com.example.lijunjie.vehiclecontrolsystem.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.util.ToastHelper;
import com.example.lijunjie.vehiclecontrolsystem.bean.MyCarBean;

import java.util.List;

/**
 * Created by Kevin on 2017/2/28.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<MyCarBean> mData;
    private PopupWindow mPopupWindow;

    public ListViewAdapter(Context context, List<MyCarBean> data, PopupWindow popupWindow) {
        mContext = context;
        mData = data;
        mPopupWindow = popupWindow;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.adapter_popup_list_view, null);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.tv_item);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.iv_icon1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextView.setText(mData.get(0).getName());
        viewHolder.imageView.setImageResource(mData.get(0).getImgId());
        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastHelper.showToast(mContext, mData.get(0).getName());
                mPopupWindow.dismiss();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView mTextView;
        ImageView imageView;
    }
}
