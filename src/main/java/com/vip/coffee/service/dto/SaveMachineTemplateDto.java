package com.vip.coffee.service.dto;

import java.util.List;

public class SaveMachineTemplateDto {
    private Long modelId;
    private List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics;

    public Long getModelId() {
        return modelId;
    }

    public SaveMachineTemplateDto setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public List<PartTypesWithCharacteristicsDto> getPartTypesWithCharacteristics() {
        return partTypesWithCharacteristics;
    }

    public SaveMachineTemplateDto setPartTypesWithCharacteristics(List<PartTypesWithCharacteristicsDto> partTypesWithCharacteristics) {
        this.partTypesWithCharacteristics = partTypesWithCharacteristics;
        return this;
    }
}
