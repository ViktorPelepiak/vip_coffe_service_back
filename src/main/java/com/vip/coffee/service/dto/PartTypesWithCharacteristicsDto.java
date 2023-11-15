package com.vip.coffee.service.dto;

import java.util.List;

public class PartTypesWithCharacteristicsDto {
    private MachinePartTypeDto partType;
    private List<CharacteristicsWithValueDto> characteristicsWithValues;

    public MachinePartTypeDto getPartType() {
        return partType;
    }

    public PartTypesWithCharacteristicsDto setPartType(MachinePartTypeDto partType) {
        this.partType = partType;
        return this;
    }

    public List<CharacteristicsWithValueDto> getCharacteristicsWithValues() {
        return characteristicsWithValues;
    }

    public PartTypesWithCharacteristicsDto setCharacteristicsWithValues(List<CharacteristicsWithValueDto> characteristicsWithValues) {
        this.characteristicsWithValues = characteristicsWithValues;
        return this;
    }
}
