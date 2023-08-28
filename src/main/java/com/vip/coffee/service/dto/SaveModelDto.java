package com.vip.coffee.service.dto;

public class SaveModelDto {
    private String brand;
    private String model;

    public String getBrand() {
        return brand;
    }

    public SaveModelDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public SaveModelDto setModel(String model) {
        this.model = model;
        return this;
    }
}
