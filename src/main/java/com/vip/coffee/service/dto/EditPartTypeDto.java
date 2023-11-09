package com.vip.coffee.service.dto;

public class EditPartTypeDto {
    private Long id;
    private String newValue;

    public Long getId() {
        return id;
    }

    public EditPartTypeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNewValue() {
        return newValue;
    }

    public EditPartTypeDto setNewValue(String newValue) {
        this.newValue = newValue;
        return this;
    }
}
