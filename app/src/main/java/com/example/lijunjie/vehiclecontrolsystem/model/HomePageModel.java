package com.example.lijunjie.vehiclecontrolsystem.model;
import com.example.lijunjie.vehiclecontrolsystem.R;
import com.example.lijunjie.vehiclecontrolsystem.base.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomePageModel {

    public static void advertisement(Banner banner , List<Integer> list ) {
        //本地图片数据（资源文件）
        list = new ArrayList<>();
        list.add(R.drawable.home_page_broadcast_1);
        list.add(R.drawable.home_page_broadcast_2);
        banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
