package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.EditPartTypeDto;
import com.vip.coffee.service.dto.SavePartTypeDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.PartType;

import java.util.List;
import java.util.NoSuchElementException;

public interface PartTypeService {
    List<PartType> getAll();

    PartType getById(Long id) throws NoSuchElementException;

    PartType save(SavePartTypeDto partType);

    PartType editPartType(EditPartTypeDto editPartTypeDto) throws NoSuchElementException;

    void deletePartTypeWithId(Long partTypeId) throws NoSuchElementException;

    PartType getPartTypeByName(String partTypeName) throws ElementNotFoundException;
}
