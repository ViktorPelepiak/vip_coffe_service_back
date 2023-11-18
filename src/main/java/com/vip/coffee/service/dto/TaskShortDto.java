package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.Task;

import java.time.format.DateTimeFormatter;

public class TaskShortDto {
    private Long id;
    private String type;
    private String status;
    private String startDate;
    private String endDate;
    private String dueDate;
    private String assignee;

    public Long getId() {
        return id;
    }

    public TaskShortDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TaskShortDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TaskShortDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public TaskShortDto setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public TaskShortDto setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public TaskShortDto setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public TaskShortDto setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public static TaskShortDto toDto(Task task) {
        return new TaskShortDto()
                .setId(task.getId())
                .setType(task.getType().getValue())
                .setStatus(task.getStatus().getValue())
                .setStartDate(
                        task.getStartDate() == null
                                ? ""
                                : task.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))
                                .replace(" ", "T")
                )
                .setEndDate(
                        task.getEndDate() == null
                                ? ""
                                : task.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))
                                .replace(" ", "T")
                )
                .setDueDate(
                        task.getDueDate() == null
                                ? ""
                                : task.getDueDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))
                                .replace(" ", "T")
                )
                .setAssignee(task.getAssignee().getUsername());
    }
}
