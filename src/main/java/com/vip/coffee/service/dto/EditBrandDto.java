package com.vip.coffee.service.dto;

public class EditBrandDto {
    private Long brandId;
    private String newValue;

    public Long getBrandId() {
        return brandId;
    }

    public EditBrandDto setBrandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getNewValue() {
        return newValue;
    }

    public EditBrandDto setNewValue(String newValue) {
        this.newValue = newValue;
        return this;
    }
}
