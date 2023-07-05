package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "characteristic_types")
public class CharacteristicType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "measurement_unit")
    private String measurementUnit;
}
