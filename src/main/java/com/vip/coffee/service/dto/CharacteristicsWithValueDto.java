package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.PartCharacteristic;

public class CharacteristicsWithValueDto {
    private MachineCharacteristicTypeDto characteristicType;
    private String characteristicTypeVal;

    public MachineCharacteristicTypeDto getCharacteristicType() {
        return characteristicType;
    }

    public CharacteristicsWithValueDto setCharacteristicType(MachineCharacteristicTypeDto characteristicType) {
        this.characteristicType = characteristicType;
        return this;
    }

    public String getCharacteristicTypeVal() {
        return characteristicTypeVal;
    }

    public CharacteristicsWithValueDto setCharacteristicTypeVal(String characteristicTypeVal) {
        this.characteristicTypeVal = characteristicTypeVal;
        return this;
    }

    public static CharacteristicsWithValueDto toDto(PartCharacteristic partCharacteristic) {
        return new CharacteristicsWithValueDto()
                .setCharacteristicTypeVal(partCharacteristic.getCharacteristicValue())
                .setCharacteristicType(MachineCharacteristicTypeDto.toDto(partCharacteristic.getCharacteristicType()));
    }
}
