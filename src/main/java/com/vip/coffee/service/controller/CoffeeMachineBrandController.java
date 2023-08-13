package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.EditBrandDto;
import com.vip.coffee.service.dto.SaveBrandDto;
import com.vip.coffee.service.model.CoffeeMachineBrand;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.CoffeeMachineBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("machine/brand")
public class CoffeeMachineBrandController {

    private final CoffeeMachineBrandService coffeeMachineBrandService;

    @Autowired
    public CoffeeMachineBrandController(CoffeeMachineBrandService coffeeMachineBrandService) {
        this.coffeeMachineBrandService = coffeeMachineBrandService;
    }

    @GetMapping
    public GenericResponse<List<CoffeeMachineBrand>> getAllCoffeeMachineBrands() {
        return GenericResponse.of(coffeeMachineBrandService.getAll());
    }

    @PostMapping
    public GenericResponse<CoffeeMachineBrand> saveBrand(@RequestBody SaveBrandDto brandDto) {
        return GenericResponse.of(this.coffeeMachineBrandService.save(brandDto));
    }

    @PutMapping
    public GenericResponse<CoffeeMachineBrand> updateBrandName(@RequestBody EditBrandDto editBrandDto) {
        try {
            return GenericResponse.of(coffeeMachineBrandService.editBrand(editBrandDto));
        } catch (NoSuchElementException e) {
            return GenericResponse.error(String.format("Brand with id=%d was not found", editBrandDto.getBrandId()));
        }
    }

    @DeleteMapping("{brandId}")
    public GenericResponse<Long> deleteBrand(@PathVariable Long brandId) {
        try {
            coffeeMachineBrandService.deleteBrandWithId(brandId);
            return GenericResponse.withSuccessMessage(String.format("Brand with id=%d was successfully deleted", brandId));
        } catch (NoSuchElementException e) {
            return GenericResponse.error(String.format("Brand with id=%d was not found", brandId));
        }
    }
}
