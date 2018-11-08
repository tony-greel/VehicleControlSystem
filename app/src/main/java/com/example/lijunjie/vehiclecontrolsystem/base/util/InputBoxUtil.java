package com.example.lijunjie.vehiclecontrolsystem.base.util;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lijunjie.vehiclecontrolsystem.R;

public class InputBoxUtil{

    private static boolean eyeOpen = false ;
    /**
     * 显示密码图片监听
     */
    public static void imgPasswordDisappearMonitor(EditText input_box , ImageView picture) {
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eyeOpen) {
                    input_box.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    picture.setImageResource(R.drawable.log_et_close);
                    eyeOpen = false;
                } else {
                    input_box.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    picture.setImageResource(R.drawable.log_et_display);
                    eyeOpen = true;
                }
            }
        });
    }

    /**
     * 显示密码图片监听
     */
    public static void imgPasswordDisappearMonitorColour(EditText input_box , ImageView picture) {
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eyeOpen) {
                    input_box.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    picture.setImageResource(R.drawable.img_close);
                    eyeOpen = false;
                } else {
                    input_box.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    picture.setImageResource(R.drawable.img_open);
                    eyeOpen = true;
                }
            }
        });
    }

    /**
     * 输入框判断监听
     */
    public static void initView(EditText input_box , ImageView picture) {
//        input_box.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});//设置限制长度，多了输入不了

        input_box.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    picture.setVisibility(View.VISIBLE);
                } else {
                    picture.setVisibility(View.GONE);
                }
            }
        });
    }
}
