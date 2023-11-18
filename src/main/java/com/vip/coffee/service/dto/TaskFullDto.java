package com.vip.coffee.service.dto;

import com.vip.coffee.service.model.Task;

import java.time.format.DateTimeFormatter;

public class TaskFullDto {
    private Long id;
    private String type;
    private String status;
    private String estimation;
    private String startDate;
    private String endDate;
    private String dueDate;
    private String assignee;
    private String inputInformation;
    private String outputInformation;

    public Long getId() {
        return id;
    }

    public TaskFullDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TaskFullDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TaskFullDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getEstimation() {
        return estimation;
    }

    public TaskFullDto setEstimation(String estimation) {
        this.estimation = estimation;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public TaskFullDto setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public TaskFullDto setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public TaskFullDto setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public TaskFullDto setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public String getInputInformation() {
        return inputInformation;
    }

    public TaskFullDto setInputInformation(String inputInformation) {
        this.inputInformation = inputInformation;
        return this;
    }

    public String getOutputInformation() {
        return outputInformation;
    }

    public TaskFullDto setOutputInformation(String outputInformation) {
        this.outputInformation = outputInformation;
        return this;
    }

    public static TaskFullDto toDto(Task task) {
        return new TaskFullDto()
                .setId(task.getId())
                .setType(task.getType().name())
                .setStatus(task.getStatus().name())
                .setEstimation(task.getEstimation())
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
                .setAssignee(task.getAssignee().getUsername())
                .setInputInformation(task.getInputInformation())
                .setOutputInformation(task.getOutputInformation());
    }
}
