package com.example.lijunjie.vehiclecontrolsystem.bean;

public class PersonalVehicleBean {

    private String vehicle;
    private String carModel;
    private String carColour;

    public PersonalVehicleBean(String vehicle , String carModel , String carColour){
        this.vehicle = vehicle;
        this.carModel = carModel;
        this.carColour = carColour;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }
}
