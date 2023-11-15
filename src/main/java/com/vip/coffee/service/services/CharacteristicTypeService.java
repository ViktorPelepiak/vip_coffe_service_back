package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.EditCharacteristicTypeDto;
import com.vip.coffee.service.dto.SaveCharacteristicTypeDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CharacteristicType;

import java.util.List;
import java.util.NoSuchElementException;

public interface CharacteristicTypeService {
    List<CharacteristicType> getAll();

    CharacteristicType getById(Long id) throws NoSuchElementException;

    CharacteristicType save(SaveCharacteristicTypeDto characteristicType);

    CharacteristicType editCharacteristicType(EditCharacteristicTypeDto editCharacteristicTypeDto)
            throws NoSuchElementException;

    void deleteCharacteristicTypeWithId(Long characteristicTypeId) throws NoSuchElementException;

    CharacteristicType getCharacteristicTypeByNameAndMeasurementUnit(String characteristicType, String measurementUnit)
            throws ElementNotFoundException;
}
