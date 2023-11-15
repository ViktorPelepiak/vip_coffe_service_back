package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.CoffeeMachine;

public class CoffeeMachineTemplateShortDto {
    private Long id;
    private String brand;
    private String model;

    public Long getId() {
        return id;
    }

    public CoffeeMachineTemplateShortDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CoffeeMachineTemplateShortDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CoffeeMachineTemplateShortDto setModel(String model) {
        this.model = model;
        return this;
    }

    public static CoffeeMachineTemplateShortDto toDto(CoffeeMachine coffeeMachine) {
        return new CoffeeMachineTemplateShortDto()
                .setId(coffeeMachine.getId())
                .setBrand(coffeeMachine.getModel().getBrand().getBrand())
                .setModel(coffeeMachine.getModel().getModel());
    }
}
