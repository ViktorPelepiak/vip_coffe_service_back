package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.CoffeeMachineModelDto;
import com.vip.coffee.service.dto.EditModelDto;
import com.vip.coffee.service.dto.SaveModelDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.CoffeeMachineModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("machine/models")
public class CoffeeMachineModelController {
    private final CoffeeMachineModelService coffeeMachineModelService;

    @Autowired
    public CoffeeMachineModelController(CoffeeMachineModelService coffeeMachineModelService) {
        this.coffeeMachineModelService = coffeeMachineModelService;
    }

    @GetMapping
    public GenericResponse<List<CoffeeMachineModelDto>> getAllCoffeeMachineModels() {
        return GenericResponse.of(
                coffeeMachineModelService.getAll()
                        .stream()
                        .map(CoffeeMachineModelDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("for_brand/{brandId}")
    public GenericResponse<List<CoffeeMachineModelDto>> getAllCoffeeMachineModelsForBrandWithId(@PathVariable Long brandId) {
        return GenericResponse.of(
                coffeeMachineModelService.getAllForBrandWithId(brandId).stream()
                .map(CoffeeMachineModelDto::toDto)
                .collect(Collectors.toList())
        );
    }

    @PostMapping
    public GenericResponse<CoffeeMachineModelDto> saveModel(@RequestBody SaveModelDto modelDto) {
        try {
            return GenericResponse.of(CoffeeMachineModelDto.toDto(this.coffeeMachineModelService.save(modelDto)))   ;
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @PutMapping
    public GenericResponse<CoffeeMachineModelDto> updateModel(@RequestBody EditModelDto editModelDto) {
        try {
            return GenericResponse.of(CoffeeMachineModelDto.toDto(coffeeMachineModelService.editModel(editModelDto)));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(String.format("Brand with id=%d was not found", editModelDto.getId()));
        }
    }

    @DeleteMapping("{modelId}")
    public GenericResponse<Long> deleteModel(@PathVariable Long modelId) {
        try {
            coffeeMachineModelService.deleteModelWithId(modelId);
            return GenericResponse.withSuccessMessage(String.format("Brand with id=\"%d\" was successfully deleted", modelId));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }
}
