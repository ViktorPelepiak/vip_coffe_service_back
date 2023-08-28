package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.EditModelDto;
import com.vip.coffee.service.dto.SaveModelDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachineModel;

import java.util.List;


public interface CoffeeMachineModelService {
    List<CoffeeMachineModel> getAll();

    CoffeeMachineModel save(SaveModelDto modelDto) throws ElementNotFoundException;

    CoffeeMachineModel editModel(EditModelDto editModelDto) throws ElementNotFoundException;

    void deleteModelWithId(Long modelId) throws ElementNotFoundException;
}
