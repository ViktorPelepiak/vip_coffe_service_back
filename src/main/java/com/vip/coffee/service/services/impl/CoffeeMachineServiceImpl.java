package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.PartTypesWithCharacteristicsDto;
import com.vip.coffee.service.dto.SaveMachineDto;
import com.vip.coffee.service.dto.SaveMachineTemplateDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.User;
import com.vip.coffee.service.repository.CoffeeMachineRepository;
import com.vip.coffee.service.services.CoffeeMachineModelService;
import com.vip.coffee.service.services.CoffeeMachineService;
import com.vip.coffee.service.services.PartCharacteristicService;
import com.vip.coffee.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;
    private final CoffeeMachineModelService modelService;
    private final PartCharacteristicService partCharacteristicService;
    private final UserService userService;

    @Autowired
    public CoffeeMachineServiceImpl(CoffeeMachineRepository coffeeMachineRepository,
                                    CoffeeMachineModelService modelService,
                                    PartCharacteristicService partCharacteristicService, UserService userService) {
        this.coffeeMachineRepository = coffeeMachineRepository;
        this.modelService = modelService;
        this.partCharacteristicService = partCharacteristicService;
        this.userService = userService;
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
                                Integer.parseInt(date[0]),
                                Integer.parseInt(date[1]),
                                Integer.parseInt(date[2])
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

        for (PartTypesWithCharacteristicsDto ptwc : saveMachineTemplateDto.getPartTypesWithCharacteristics()) {
            coffeeMachine.getParts().addAll(partCharacteristicService.saveAll(coffeeMachine, ptwc));
        }

        return coffeeMachineRepository.save(coffeeMachine);
    }

    @Override
    public CoffeeMachine getTemplateById(Long templateId) throws ElementNotFoundException {
        return coffeeMachineRepository.findFirstTemplateById(templateId).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public boolean isMachineWithUniqNumberExist(String uniqMachineNumber) {
        try {
            coffeeMachineRepository.findFirstByUniqueMachineNumber(uniqMachineNumber)
                    .orElseThrow(ElementNotFoundException::new);
            return true;
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    @Override
    public CoffeeMachine getById(Long machineId) throws ElementNotFoundException {
        return coffeeMachineRepository.findById(machineId).orElseThrow(() -> new ElementNotFoundException(
                String.format("Can't find machine wth id=\"%s\"", machineId)
        ));
    }

    @Override
    public List<CoffeeMachine> getAllMachinesForLoggedUser() throws ElementNotFoundException {
        return new LinkedList<>(
                userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                        .getCoffeeMachines()
        );
    }

    @Override
    public CoffeeMachine addMachineWithUniqNumber(String uniqNumber) throws ElementNotFoundException {
        User loggedUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        CoffeeMachine machine = coffeeMachineRepository.findFirstByUniqueMachineNumber(uniqNumber).orElseThrow(() ->
                new ElementNotFoundException(
                        String.format("Can't find machine with uniq number \"%s\"", uniqNumber)
                )
        );
        machine.setOwner(loggedUser);
        loggedUser.getCoffeeMachines().add(machine);
        coffeeMachineRepository.save(machine);
        userService.update(loggedUser);

        return machine;
    }
}
