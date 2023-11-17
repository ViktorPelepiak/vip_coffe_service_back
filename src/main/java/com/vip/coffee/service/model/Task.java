package com.vip.coffee.service.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private CoffeeMachine coffeeMachine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_type_id")
    private TaskType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_status_id")
    private TaskStatus status;

    private String estimation;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Column(name = "input_information")
    private String inputInformation;

    @Column(name = "output_information")
    private String outputInformation;

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public Task setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        return this;
    }

    public TaskType getType() {
        return type;
    }

    public Task setType(TaskType type) {
        this.type = type;
        return this;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task setStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    public String getEstimation() {
        return estimation;
    }

    public Task setEstimation(String estimation) {
        this.estimation = estimation;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Task setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Task setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public User getAssignee() {
        return assignee;
    }

    public Task setAssignee(User assignee) {
        this.assignee = assignee;
        return this;
    }

    public String getInputInformation() {
        return inputInformation;
    }

    public Task setInputInformation(String inputInformation) {
        this.inputInformation = inputInformation;
        return this;
    }

    public String getOutputInformation() {
        return outputInformation;
    }

    public Task setOutputInformation(String outputInformation) {
        this.outputInformation = outputInformation;
        return this;
    }
}
