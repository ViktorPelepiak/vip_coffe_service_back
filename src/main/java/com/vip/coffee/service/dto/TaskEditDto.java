package com.vip.coffee.service.dto;

public class TaskEditDto extends TaskSaveDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public TaskEditDto setId(Long id) {
        this.id = id;
        return this;
    }
}
