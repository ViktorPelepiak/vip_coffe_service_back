package com.vip.coffee.service.dto;

public class SaveCharacteristicTypeDto {
    private String characteristicType;
    private String measurementUnit;

    public String getCharacteristicType() {
        return characteristicType;
    }

    public SaveCharacteristicTypeDto setCharacteristicType(String characteristicType) {
        this.characteristicType = characteristicType;
        return this;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public SaveCharacteristicTypeDto setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
        return this;
    }
}
