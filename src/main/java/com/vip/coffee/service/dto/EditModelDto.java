package com.vip.coffee.service.dto;

public class EditModelDto {
    private Long id;
    private String brandName;
    private String modelName;

    public Long getId() {
        return id;
    }

    public EditModelDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public EditModelDto setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public EditModelDto setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }
}
