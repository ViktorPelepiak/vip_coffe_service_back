package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "task_statuses")
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    public Long getId() {
        return id;
    }

    public TaskStatus setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TaskStatus setStatus(String status) {
        this.status = status;
        return this;
    }
}
