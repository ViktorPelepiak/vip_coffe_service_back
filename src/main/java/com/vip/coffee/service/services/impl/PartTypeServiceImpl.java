package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.EditPartTypeDto;
import com.vip.coffee.service.dto.PartTypeSaveDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachineBrand;
import com.vip.coffee.service.model.PartType;
import com.vip.coffee.service.repository.PartTypeRepository;
import com.vip.coffee.service.services.PartTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PartTypeServiceImpl implements PartTypeService {

    private final PartTypeRepository partTypeRepository;

    @Autowired
    public PartTypeServiceImpl(PartTypeRepository partTypeRepository) {
        this.partTypeRepository = partTypeRepository;
    }

    @Override
    public List<PartType> getAll() {
        return partTypeRepository.getAllByOrderByType();
    }

    @Override
    public PartType save(PartTypeSaveDto partType) {
        return partTypeRepository.save(
                new PartType()
                .setType(partType.getNewPartType())
        );
    }

    @Override
    public PartType editPartType(EditPartTypeDto editPartTypeDto) throws NoSuchElementException {
        PartType partType = partTypeRepository.findById(editPartTypeDto.getId()).orElseThrow(NoSuchElementException::new);
        partType.setType(editPartTypeDto.getNewValue());
        return partTypeRepository.save(partType);
    }

    @Override
    public void deletePartTypeWithId(Long partTypeId) throws NoSuchElementException {
        PartType partType = partTypeRepository.findById(partTypeId).orElseThrow(NoSuchElementException::new);
        partTypeRepository.delete(partType);
    }

    @Override
    public PartType getPartTypeByName(String partTypeName) throws ElementNotFoundException {
        return partTypeRepository.findFirstByType(partTypeName)
                .orElseThrow(() -> new ElementNotFoundException(
                        String.format("Can't find part type wth name \"%s\"", partTypeName)
                ));
    }
}
