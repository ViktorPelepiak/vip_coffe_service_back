package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.SaveMachineDto;
import com.vip.coffee.service.dto.SaveMachineTemplateDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachine;

import java.util.List;

public interface CoffeeMachineService {
    List<CoffeeMachine> getAllMachines();

    List<CoffeeMachine> getAllTemplates();

    CoffeeMachine saveMachine(SaveMachineDto saveMachineDto) throws ElementNotFoundException;

    CoffeeMachine saveMachineTemplate(SaveMachineTemplateDto saveMachineTemplateDto) throws ElementNotFoundException;

    CoffeeMachine getTemplateById(Long templateId) throws ElementNotFoundException;

    boolean isMachineWithUniqNumberExist(String uniqMachineNumber);

    CoffeeMachine getById(Long machineId) throws ElementNotFoundException;

    List<CoffeeMachine> getAllMachinesForLoggedUser() throws ElementNotFoundException;

    CoffeeMachine addMachineWithUniqNumber(String uniqNumber) throws ElementNotFoundException;
}
