package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.*;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("machines")
public class CoffeeMachineController {

    private final CoffeeMachineService coffeeMachineService;

    @Autowired
    public CoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

    @GetMapping
    public GenericResponse<List<CoffeeMachineShortDto>> getAllMachines() {
        return GenericResponse.of(
                coffeeMachineService.getAllMachines().stream()
                        .map(CoffeeMachineShortDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{machineId}")
    public GenericResponse<CoffeeMachineDto> getCoffeeMachineById(@PathVariable Long machineId) {
        try {
            return GenericResponse.of(CoffeeMachineDto.toDto(coffeeMachineService.getById(machineId)));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @GetMapping("exist/{uniqMachineNumber}")
    public GenericResponse<Boolean> isMachineWithUniqNumberExist(@PathVariable String uniqMachineNumber) {
        return GenericResponse.of(coffeeMachineService.isMachineWithUniqNumberExist(uniqMachineNumber));
    }

    @GetMapping("template")
    public GenericResponse<List<CoffeeMachineTemplateShortDto>> getAllTemplates() {
        return GenericResponse.of(
                coffeeMachineService.getAllTemplates().stream()
                        .map(CoffeeMachineTemplateShortDto::toDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("template/{templateId}")
    public GenericResponse<CoffeeMachineTemplateDto> getTemplateById(@PathVariable Long templateId) {
        try {
            return GenericResponse.of(CoffeeMachineTemplateDto.toDto(coffeeMachineService.getTemplateById(templateId)));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @GetMapping("my")
    GenericResponse<List<CoffeeMachineShortDto>> getAllMachinesForLoggedUser() {
        try {
            return GenericResponse.of(
                    coffeeMachineService.getAllMachinesForLoggedUser().stream()
                            .map(CoffeeMachineShortDto::toDto)
                    .collect(Collectors.toList())
            );
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @PostMapping
    public GenericResponse<CoffeeMachine> save(@RequestBody SaveMachineDto saveMachineDto) {
        try {
            return GenericResponse.of(coffeeMachineService.saveMachine(saveMachineDto));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @PostMapping("template")
    public GenericResponse<CoffeeMachine> save(@RequestBody SaveMachineTemplateDto saveMachineDto) {
        try {
            return GenericResponse.of(coffeeMachineService.saveMachineTemplate(saveMachineDto));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @PostMapping("add")
    public GenericResponse<CoffeeMachineShortDto> addMachine(@RequestBody String uniqNumber) {
        try {
            return GenericResponse.of(CoffeeMachineShortDto.toDto(coffeeMachineService.addMachineWithUniqNumber(uniqNumber)));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }
}
