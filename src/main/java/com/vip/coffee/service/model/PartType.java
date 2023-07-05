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
}
