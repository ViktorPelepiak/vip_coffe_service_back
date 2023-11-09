package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.EditCharacteristicTypeDto;
import com.vip.coffee.service.dto.SaveCharacteristicTypeDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CharacteristicType;
import com.vip.coffee.service.repository.CharacteristicTypeRepository;
import com.vip.coffee.service.services.CharacteristicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CharacteristicTypeServiceImpl implements CharacteristicTypeService {

    private final CharacteristicTypeRepository characteristicTypeRepository;

    @Autowired
    public CharacteristicTypeServiceImpl(CharacteristicTypeRepository characteristicTypeRepository) {
        this.characteristicTypeRepository = characteristicTypeRepository;
    }

    @Override
    public List<CharacteristicType> getAll() {
        return characteristicTypeRepository.getAllByOrderByTypeAscMeasurementUnit();
    }

    @Override
    public CharacteristicType save(SaveCharacteristicTypeDto characteristicType) {
        return characteristicTypeRepository.save(
                new CharacteristicType()
                .setType(characteristicType.getCharacteristicType())
                .setMeasurementUnit(characteristicType.getMeasurementUnit())
        );
    }

    @Override
    public CharacteristicType editCharacteristicType(EditCharacteristicTypeDto editCharacteristicTypeDto) throws NoSuchElementException {
        CharacteristicType characteristicType = characteristicTypeRepository
                .findById(editCharacteristicTypeDto.getId())
                .orElseThrow(NoSuchElementException::new);
        characteristicType
                .setType(editCharacteristicTypeDto.getNewType())
                .setMeasurementUnit(editCharacteristicTypeDto.getNewMeasurementUnit());
        return characteristicTypeRepository.save(characteristicType);
    }

    @Override
    public void deleteCharacteristicTypeWithId(Long characteristicTypeId) throws NoSuchElementException {
        CharacteristicType characteristicType = characteristicTypeRepository
                .findById(characteristicTypeId)
                .orElseThrow(NoSuchElementException::new);
        characteristicTypeRepository.delete(characteristicType);
    }

    @Override
    public CharacteristicType getCharacteristicTypeByNameAndMeasurementUnit(String characteristicType, String measurementUnit) throws ElementNotFoundException {
        return characteristicTypeRepository.findFirstByTypeAndMeasurementUnit(characteristicType, measurementUnit)
                .orElseThrow(() -> new ElementNotFoundException(
                        String.format("Can't find characteristic type type wth type name \"%s\" and measurement unit \"%s\"", characteristicType, measurementUnit)
                ));
    }
}
