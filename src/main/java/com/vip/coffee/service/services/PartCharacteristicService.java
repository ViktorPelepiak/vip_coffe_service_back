package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.PartTypesWithCharacteristicsDto;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.PartCharacteristic;

import java.util.List;

public interface PartCharacteristicService {
    List<PartCharacteristic> saveAll(CoffeeMachine coffeeMachine, PartTypesWithCharacteristicsDto partCharacteristicDto);
}
