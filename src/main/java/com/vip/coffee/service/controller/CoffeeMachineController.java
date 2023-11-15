package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.CoffeeMachineShortDto;
import com.vip.coffee.service.dto.CoffeeMachineTemplateShortDto;
import com.vip.coffee.service.dto.SaveMachineDto;
import com.vip.coffee.service.dto.SaveMachineTemplateDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.CoffeeMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("machine")
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

    @GetMapping("template")
    public GenericResponse<List<CoffeeMachineTemplateShortDto>> getAllTemplates() {
        return GenericResponse.of(
                coffeeMachineService.getAllTemplates().stream()
                        .map(CoffeeMachineTemplateShortDto::toDto)
                        .collect(Collectors.toList())
        );
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
}
