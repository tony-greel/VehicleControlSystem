package com.example.lijunjie.vehiclecontrolsystem.bean;

import java.util.List;

public class HomePageBean extends BaseRequestBean{
    private int img;
    private String name;

    public HomePageBean(String name , int img ){
        this.name = name;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
