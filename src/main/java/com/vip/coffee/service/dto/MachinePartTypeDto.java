package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.PartType;

public class MachinePartTypeDto {
    private Long id;
    private String type;

    public Long getId() {
        return id;
    }

    public MachinePartTypeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public MachinePartTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    public static MachinePartTypeDto toDto(PartType partType) {
        return new MachinePartTypeDto()
                .setId(partType.getId())
                .setType(partType.getType());
    }
}
