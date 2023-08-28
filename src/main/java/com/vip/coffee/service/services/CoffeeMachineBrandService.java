package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.EditBrandDto;
import com.vip.coffee.service.dto.SaveBrandDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachineBrand;

import java.util.List;
import java.util.NoSuchElementException;

public interface CoffeeMachineBrandService {

    List<CoffeeMachineBrand> getAll();

    CoffeeMachineBrand save(SaveBrandDto brandDto);

    CoffeeMachineBrand editBrand(EditBrandDto editBrandDto) throws NoSuchElementException;

    void deleteBrandWithId(Long brandId) throws NoSuchElementException;

    CoffeeMachineBrand getBrandByName(String brand) throws ElementNotFoundException;
}
