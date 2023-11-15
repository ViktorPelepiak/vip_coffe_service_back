package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.PartTypesWithCharacteristicsDto;
import com.vip.coffee.service.dto.SaveMachineDto;
import com.vip.coffee.service.dto.SaveMachineTemplateDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.repository.CoffeeMachineRepository;
import com.vip.coffee.service.services.CoffeeMachineModelService;
import com.vip.coffee.service.services.CoffeeMachineService;
import com.vip.coffee.service.services.PartCharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;
    private final CoffeeMachineModelService modelService;
    private final PartCharacteristicService partCharacteristicService;

    @Autowired
    public CoffeeMachineServiceImpl(CoffeeMachineRepository coffeeMachineRepository,
                                    CoffeeMachineModelService modelService,
                                    PartCharacteristicService partCharacteristicService) {
        this.coffeeMachineRepository = coffeeMachineRepository;
        this.modelService = modelService;
        this.partCharacteristicService = partCharacteristicService;
    }

    @Override
    public List<CoffeeMachine> getAllMachines() {
        return coffeeMachineRepository.findAllMachines();
    }

    @Override
    public List<CoffeeMachine> getAllTemplates() {
        return coffeeMachineRepository.findAllTemplates();
    }

    @Override
    public CoffeeMachine saveMachine(SaveMachineDto saveMachineDto) throws ElementNotFoundException {
        String[] date = saveMachineDto.getWarrantyEndDate().split("-");
        return coffeeMachineRepository.save(
                saveMachineTemplate(saveMachineDto)
                .setTemplate(false)
                .setUniqueMachineNumber(saveMachineDto.getUniqMachineNumber())
                .setAdditionalInformation(saveMachineDto.getAdditionalInformation())
                .setWarrantyEndDate(LocalDate.of(
                        Integer.parseInt(date[0]) - 1,
                        Integer.parseInt(date[1]) - 1,
                        Integer.parseInt(date[2]) - 1
                ))
        );
    }

    @Override
    public CoffeeMachine saveMachineTemplate(SaveMachineTemplateDto saveMachineTemplateDto) throws ElementNotFoundException {
        CoffeeMachine coffeeMachine = coffeeMachineRepository.save(new CoffeeMachine()
                .setModel(modelService.getById(saveMachineTemplateDto.getModelId()))
                .setTemplate(true)
        );
        if (coffeeMachine.getParts() == null) {
            coffeeMachine.setParts(new LinkedList<>());
        }

        for (PartTypesWithCharacteristicsDto ptwc: saveMachineTemplateDto.getPartTypesWithCharacteristics()) {
            coffeeMachine.getParts().addAll(partCharacteristicService.saveAll(coffeeMachine, ptwc));
        }

        return coffeeMachineRepository.save(coffeeMachine);
    }
}
