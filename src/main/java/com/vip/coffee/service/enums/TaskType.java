package com.vip.coffee.service.enums;

public enum TaskType {
    INVESTIGATION("Діагностика"),
    REPAIRING("Ремонт"),
    MAINTENANCE("Тех. огляд");

    private final String value;

    TaskType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
