package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.EditModelDto;
import com.vip.coffee.service.dto.SaveModelDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachineModel;
import com.vip.coffee.service.repository.CoffeeMachineModelRepository;
import com.vip.coffee.service.services.CoffeeMachineBrandService;
import com.vip.coffee.service.services.CoffeeMachineModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoffeeMachineModelServiceImpl implements CoffeeMachineModelService {
    private final CoffeeMachineBrandService coffeeMachineBrandService;
    private final CoffeeMachineModelRepository coffeeMachineModelRepository;

    @Autowired
    public CoffeeMachineModelServiceImpl(CoffeeMachineBrandService coffeeMachineBrandService,
                                         CoffeeMachineModelRepository coffeeMachineModelRepository) {
        this.coffeeMachineBrandService = coffeeMachineBrandService;
        this.coffeeMachineModelRepository = coffeeMachineModelRepository;
    }

    @Override
    public List<CoffeeMachineModel> getAll() {
        return coffeeMachineModelRepository.getAllByOrderByBrandAscModelAsc();
    }

    @Override
    public CoffeeMachineModel getById(Long id) throws ElementNotFoundException {
        return coffeeMachineModelRepository.findFirstById(id)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public List<CoffeeMachineModel> getAllForBrandWithId(Long brandId) {
        return coffeeMachineModelRepository.findAllByBrandOrderByModelAsc(
                coffeeMachineBrandService.getById(brandId)
        );
    }

    @Override
    public CoffeeMachineModel save(SaveModelDto modelDto) throws ElementNotFoundException {
        return coffeeMachineModelRepository.save(new CoffeeMachineModel()
        .setModel(modelDto.getModel())
        .setBrand(coffeeMachineBrandService.getBrandByName(modelDto.getBrand())));
    }

    @Override
    public CoffeeMachineModel editModel(EditModelDto editModelDto) throws ElementNotFoundException {
        try {
            CoffeeMachineModel model = coffeeMachineModelRepository.getReferenceById(editModelDto.getId());
            if (!model.getBrand().getBrand().equals(editModelDto.getBrandName())) {
                model.setBrand(coffeeMachineBrandService.getBrandByName(editModelDto.getBrandName()));
            }
            model.setModel(editModelDto.getModelName());
            return coffeeMachineModelRepository.save(model);

        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(String.format("Model with id=\"%d\" wasn't found", editModelDto.getId()));
        }
    }

    @Override
    public void deleteModelWithId(Long modelId) throws ElementNotFoundException {
        try {
            coffeeMachineModelRepository.getReferenceById(modelId);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException(String.format("Model with id=\"%d\" was not found", modelId));
        }
        coffeeMachineModelRepository.deleteById(modelId);
    }
}
