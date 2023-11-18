package com.vip.coffee.service.dto;

public class TaskSaveDto {
    private Long machineId;
    private String type;
    private String status;
    private String estimation;
    private String startDate;
    private String endDate;
    private String dueDate;
    private String assignee;
    private String inputInformation;
    private String outputInformation;

    public Long getMachineId() {
        return machineId;
    }

    public TaskSaveDto setMachineId(Long machineId) {
        this.machineId = machineId;
        return this;
    }

    public String getType() {
        return type;
    }

    public TaskSaveDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TaskSaveDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getEstimation() {
        return estimation;
    }

    public TaskSaveDto setEstimation(String estimation) {
        this.estimation = estimation;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public TaskSaveDto setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public TaskSaveDto setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public TaskSaveDto setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getAssignee() {
        return assignee;
    }

    public TaskSaveDto setAssignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public String getInputInformation() {
        return inputInformation;
    }

    public TaskSaveDto setInputInformation(String inputInformation) {
        this.inputInformation = inputInformation;
        return this;
    }

    public String getOutputInformation() {
        return outputInformation;
    }

    public TaskSaveDto setOutputInformation(String outputInformation) {
        this.outputInformation = outputInformation;
        return this;
    }
}
