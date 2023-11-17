package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.PartCharacteristic;
import com.vip.coffee.service.model.PartType;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoffeeMachineTemplateDto {
    private Long brandId;
    private Long modelId;
    private List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics;

    public Long getBrandId() {
        return brandId;
    }

    public CoffeeMachineTemplateDto setBrandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public Long getModelId() {
        return modelId;
    }

    public CoffeeMachineTemplateDto setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public List<PartTypesWithCharacteristicsDto> getPartTypesWithCharacteristics() {
        return partTypesWithCharacteristics;
    }

    public CoffeeMachineTemplateDto setPartTypesWithCharacteristics(List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics) {
        this.partTypesWithCharacteristics = partTypesWithCharacteristics;
        return this;
    }

    public static CoffeeMachineTemplateDto toDto(CoffeeMachine coffeeMachine) {
        Set<PartType> partTypes = coffeeMachine.getParts().stream()
                .map(PartCharacteristic::getPartType)
                .collect(Collectors.toSet());

        List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics = new LinkedList<>();
        for (PartType pt : partTypes) {
            partTypesWithCharacteristics.add(
                    new PartTypesWithCharacteristicsDto()
                            .setPartType(MachinePartTypeDto.toDto(pt))
                            .setCharacteristicsWithValues(
                                    coffeeMachine.getParts().stream()
                                            .filter(part -> part.getPartType().equals(pt))
                                            .map(CharacteristicsWithValueDto::toDto)
                                            .collect(Collectors.toList())
                            )
            );
        }

        return new CoffeeMachineTemplateDto()
                .setBrandId(coffeeMachine.getModel().getBrand().getId())
                .setModelId(coffeeMachine.getModel().getId())
                .setPartTypesWithCharacteristics(partTypesWithCharacteristics);
    }
}
