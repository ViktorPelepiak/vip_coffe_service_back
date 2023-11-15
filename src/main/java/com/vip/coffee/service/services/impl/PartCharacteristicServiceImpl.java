package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.CharacteristicsWithValueDto;
import com.vip.coffee.service.dto.PartTypesWithCharacteristicsDto;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.PartCharacteristic;
import com.vip.coffee.service.model.PartType;
import com.vip.coffee.service.repository.PartCharacteristicRepository;
import com.vip.coffee.service.services.CharacteristicTypeService;
import com.vip.coffee.service.services.PartCharacteristicService;
import com.vip.coffee.service.services.PartTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class PartCharacteristicServiceImpl implements PartCharacteristicService {

    private final CharacteristicTypeService characteristicTypeService;
    private final PartCharacteristicRepository partCharacteristicRepository;
    private final PartTypeService partTypeService;

    @Autowired
    public PartCharacteristicServiceImpl(CharacteristicTypeService characteristicTypeService,
                                         PartCharacteristicRepository partCharacteristicRepository,
                                         PartTypeService partTypeService) {
        this.characteristicTypeService = characteristicTypeService;
        this.partCharacteristicRepository = partCharacteristicRepository;
        this.partTypeService = partTypeService;
    }

    @Override
    public List<PartCharacteristic> saveAll(CoffeeMachine coffeeMachine, PartTypesWithCharacteristicsDto partCharacteristicDto) {
        List<PartCharacteristic> result = new LinkedList<>();
        PartType partType = partTypeService.getById(partCharacteristicDto.getPartType().getId());

        for (CharacteristicsWithValueDto cwv : partCharacteristicDto.getCharacteristicsWithValues()) {
            result.add(
                    partCharacteristicRepository.save(new PartCharacteristic()
                            .setPartType(partType)
                            .setCharacteristicType(characteristicTypeService.getById(cwv.getCharacteristicType().getId()))
                            .setCharacteristicValue(cwv.getCharacteristicTypeVal())
                            .setCoffeeMachine(coffeeMachine)
                    )
            );
        }
        return result;
    }
}
