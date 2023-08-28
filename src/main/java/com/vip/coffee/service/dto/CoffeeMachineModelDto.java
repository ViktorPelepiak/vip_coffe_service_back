package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.CoffeeMachineModel;

public class CoffeeMachineModelDto {
    private Long id;
    private String brand;
    private String model;

    public Long getId() {
        return id;
    }

    public CoffeeMachineModelDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CoffeeMachineModelDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CoffeeMachineModelDto setModel(String model) {
        this.model = model;
        return this;
    }

    public static CoffeeMachineModelDto toDto(CoffeeMachineModel entity) {
        return new CoffeeMachineModelDto()
                .setId(entity.getId())
                .setBrand(entity.getBrand().getBrand())
                .setModel(entity.getModel());
    }
}
