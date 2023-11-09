package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "part_types")
public class PartType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    public Long getId() {
        return id;
    }

    public PartType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public PartType setType(String type) {
        this.type = type;
        return this;
    }
}
