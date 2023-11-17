package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.CharacteristicType;

public class MachineCharacteristicTypeDto {
    private Long id;
    private String type;
    private String measurementUnit;

    public Long getId() {
        return id;
    }

    public MachineCharacteristicTypeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public MachineCharacteristicTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public MachineCharacteristicTypeDto setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
        return this;
    }

    public static MachineCharacteristicTypeDto toDto (CharacteristicType characteristicType) {
        return new MachineCharacteristicTypeDto()
                .setId(characteristicType.getId())
                .setType(characteristicType.getType())
                .setMeasurementUnit(characteristicType.getMeasurementUnit());
    }
}
