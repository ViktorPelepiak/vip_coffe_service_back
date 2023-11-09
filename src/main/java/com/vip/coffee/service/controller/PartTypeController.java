package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.EditPartTypeDto;
import com.vip.coffee.service.dto.SavePartTypeDto;
import com.vip.coffee.service.model.PartType;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.PartTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("machine/part_type")
public class PartTypeController {

    private final PartTypeService partTypeService;

    @Autowired
    public PartTypeController(PartTypeService partTypeService) {
        this.partTypeService = partTypeService;
    }

    @GetMapping
    public GenericResponse<List<PartType>> getAllPartTypes() {
        return GenericResponse.of(partTypeService.getAll());
    }

    @PostMapping
    public GenericResponse<PartType> savePartType(@RequestBody SavePartTypeDto savePartTypeDto) {
        return GenericResponse.of(this.partTypeService.save(savePartTypeDto));
    }

    @PutMapping
    public GenericResponse<PartType> updatePartTypeName(@RequestBody EditPartTypeDto editPartTypeDto) {
        try {
            return GenericResponse.of(partTypeService.editPartType(editPartTypeDto));
        } catch (NoSuchElementException e) {
            return GenericResponse.error(String.format("Part type with id=%d was not found", editPartTypeDto.getId()));
        }
    }

    @DeleteMapping("{partTypeId}")
    public GenericResponse<Long> deletePartType(@PathVariable Long partTypeId) {
        try {
            partTypeService.deletePartTypeWithId(partTypeId);
            return GenericResponse.withSuccessMessage(String.format("Part type with id=%d was successfully deleted", partTypeId));
        } catch (NoSuchElementException e) {
            return GenericResponse.error(String.format("Part type with id=%d was not found", partTypeId));
        }
    }
}
