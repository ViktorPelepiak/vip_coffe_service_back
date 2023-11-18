package com.vip.coffee.service.enums;

public enum TaskStatus {
    NEW("Новий"),
    SCHEDULED("Заплановано"),
    IN_PROGRESS("В процесі"),
    DONE("Готово");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
