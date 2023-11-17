package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "task_types")
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    public Long getId() {
        return id;
    }

    public TaskType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public TaskType setType(String type) {
        this.type = type;
        return this;
    }
}
