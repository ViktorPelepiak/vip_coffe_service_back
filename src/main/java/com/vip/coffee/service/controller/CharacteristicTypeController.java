package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.EditCharacteristicTypeDto;
import com.vip.coffee.service.dto.SaveCharacteristicTypeDto;
import com.vip.coffee.service.model.CharacteristicType;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.CharacteristicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("machine/characteristic_type")
public class CharacteristicTypeController {

    private final CharacteristicTypeService characteristicTypeService;

    @Autowired
    public CharacteristicTypeController(CharacteristicTypeService characteristicTypeService) {
        this.characteristicTypeService = characteristicTypeService;
    }

    @GetMapping
    public GenericResponse<List<CharacteristicType>> getAllCharacteristicTypes() {
        return GenericResponse.of(characteristicTypeService.getAll());
    }

    @PostMapping
    public GenericResponse<CharacteristicType> saveCharacteristicType(@RequestBody SaveCharacteristicTypeDto saveCharacteristicTypeDto) {
        return GenericResponse.of(this.characteristicTypeService.save(saveCharacteristicTypeDto));
    }

    @PutMapping
    public GenericResponse<CharacteristicType> updatePartTypeName(@RequestBody EditCharacteristicTypeDto editCharacteristicTypeDto) {
        try {
            return GenericResponse.of(characteristicTypeService.editCharacteristicType(editCharacteristicTypeDto));
        } catch (NoSuchElementException e) {
            return GenericResponse.error(String.format("Characteristic type with id=%d was not found", editCharacteristicTypeDto.getId()));
        }
    }

    @DeleteMapping("{characteristicTypeId}")
    public GenericResponse<Long> deleteCharacteristicType(@PathVariable Long characteristicTypeId) {
        try {
            characteristicTypeService.deleteCharacteristicTypeWithId(characteristicTypeId);
            return GenericResponse.withSuccessMessage(String.format("Characteristic type with id=%d was successfully deleted", characteristicTypeId));
        } catch (NoSuchElementException e) {
            return GenericResponse.error(String.format("Characteristic type with id=%d was not found", characteristicTypeId));
        }
    }
}
