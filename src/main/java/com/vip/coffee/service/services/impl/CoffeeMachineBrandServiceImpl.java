package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.EditBrandDto;
import com.vip.coffee.service.dto.SaveBrandDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachineBrand;
import com.vip.coffee.service.repository.CoffeeMachineBrandRepository;
import com.vip.coffee.service.services.CoffeeMachineBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CoffeeMachineBrandServiceImpl implements CoffeeMachineBrandService {

    private final CoffeeMachineBrandRepository coffeeMachineBrandRepository;

    @Autowired
    public CoffeeMachineBrandServiceImpl(CoffeeMachineBrandRepository coffeeMachineBrandRepository) {
        this.coffeeMachineBrandRepository = coffeeMachineBrandRepository;
    }

    @Override
    public List<CoffeeMachineBrand> getAll() {
        return coffeeMachineBrandRepository.getAllByOrderByBrand();
    }

    @Override
    public CoffeeMachineBrand save(SaveBrandDto brandDto) {
        return this.coffeeMachineBrandRepository.save(
                new CoffeeMachineBrand()
                        .setBrand(brandDto.getNewBrandName())
        );
    }

    @Override
    public CoffeeMachineBrand editBrand(EditBrandDto editBrandDto) throws NoSuchElementException{
        CoffeeMachineBrand brand = coffeeMachineBrandRepository.findById(editBrandDto.getBrandId()).orElseThrow(NoSuchElementException::new);
        brand.setBrand(editBrandDto.getNewValue());
        return coffeeMachineBrandRepository.save(brand);
    }

    @Override
    public void deleteBrandWithId(Long brandId) throws NoSuchElementException{
        CoffeeMachineBrand brand = coffeeMachineBrandRepository.findById(brandId).orElseThrow(NoSuchElementException::new);
        if (brand != null) {
            coffeeMachineBrandRepository.deleteById(brandId);
        }
    }

    @Override
    public CoffeeMachineBrand getBrandByName(String brand) throws ElementNotFoundException {
        return coffeeMachineBrandRepository.findFirstByBrand(brand)
                .orElseThrow(() -> new ElementNotFoundException(
                        String.format("Can't find Brand wth name \"%s\"", brand)
                ));
    }
}
