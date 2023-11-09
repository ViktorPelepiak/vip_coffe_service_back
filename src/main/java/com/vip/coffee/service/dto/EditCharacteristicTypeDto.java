package com.vip.coffee.service.dto;

public class EditCharacteristicTypeDto {
    private Long id;
    private String newType;
    private String newMeasurementUnit;

    public Long getId() {
        return id;
    }

    public EditCharacteristicTypeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNewType() {
        return newType;
    }

    public EditCharacteristicTypeDto setNewType(String newType) {
        this.newType = newType;
        return this;
    }

    public String getNewMeasurementUnit() {
        return newMeasurementUnit;
    }

    public EditCharacteristicTypeDto setNewMeasurementUnit(String newMeasurementUnit) {
        this.newMeasurementUnit = newMeasurementUnit;
        return this;
    }
}
