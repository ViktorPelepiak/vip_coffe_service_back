package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.CoffeeMachine;

import java.time.format.DateTimeFormatter;

public class CoffeeMachineShortDto {
    private Long id;
    private String uniqMachineNumber;
    private String brand;
    private String model;
    private String warrantyUntil;
    private String owner;

    public Long getId() {
        return id;
    }

    public CoffeeMachineShortDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUniqMachineNumber() {
        return uniqMachineNumber;
    }

    public CoffeeMachineShortDto setUniqMachineNumber(String uniqMachineNumber) {
        this.uniqMachineNumber = uniqMachineNumber;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CoffeeMachineShortDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CoffeeMachineShortDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getWarrantyUntil() {
        return warrantyUntil;
    }

    public CoffeeMachineShortDto setWarrantyUntil(String warrantyUntil) {
        this.warrantyUntil = warrantyUntil;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public CoffeeMachineShortDto setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public static CoffeeMachineShortDto toDto(CoffeeMachine coffeeMachine) {
        String username = coffeeMachine.getOwner()!=null ? coffeeMachine.getOwner().getUsername() : "empty";
        return new CoffeeMachineShortDto()
                .setId(coffeeMachine.getId())
                .setBrand(coffeeMachine.getModel().getBrand().getBrand())
                .setModel(coffeeMachine.getModel().getModel())
                .setUniqMachineNumber(coffeeMachine.getUniqueMachineNumber())
                .setWarrantyUntil(coffeeMachine.getWarrantyEndDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setOwner(username);
    }
}
