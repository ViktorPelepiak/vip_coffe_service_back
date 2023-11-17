package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.PartCharacteristic;
import com.vip.coffee.service.model.PartType;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoffeeMachineDto {
    private Long id;
    private String uniqMachineNumber;
    private String brand;
    private String model;
    private String warrantyUntil;
    private String owner;
    private String additionalInfo;
    private List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics;

    public Long getId() {
        return id;
    }

    public CoffeeMachineDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUniqMachineNumber() {
        return uniqMachineNumber;
    }

    public CoffeeMachineDto setUniqMachineNumber(String uniqMachineNumber) {
        this.uniqMachineNumber = uniqMachineNumber;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CoffeeMachineDto setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CoffeeMachineDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getWarrantyUntil() {
        return warrantyUntil;
    }

    public CoffeeMachineDto setWarrantyUntil(String warrantyUntil) {
        this.warrantyUntil = warrantyUntil;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public CoffeeMachineDto setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public CoffeeMachineDto setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public List<PartTypesWithCharacteristicsDto> getPartTypesWithCharacteristics() {
        return partTypesWithCharacteristics;
    }

    public CoffeeMachineDto setPartTypesWithCharacteristics(List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics) {
        this.partTypesWithCharacteristics = partTypesWithCharacteristics;
        return this;
    }

    public static CoffeeMachineDto toDto(CoffeeMachine coffeeMachine) {
        String username = coffeeMachine.getOwner()!=null ? coffeeMachine.getOwner().getUsername() : "empty";

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

        return new CoffeeMachineDto()
                .setId(coffeeMachine.getId())
                .setBrand(coffeeMachine.getModel().getBrand().getBrand())
                .setModel(coffeeMachine.getModel().getModel())
                .setUniqMachineNumber(coffeeMachine.getUniqueMachineNumber())
                .setWarrantyUntil(coffeeMachine.getWarrantyEndDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setOwner(username)
                .setAdditionalInfo(coffeeMachine.getAdditionalInformation())
                .setPartTypesWithCharacteristics(partTypesWithCharacteristics);
    }
}
