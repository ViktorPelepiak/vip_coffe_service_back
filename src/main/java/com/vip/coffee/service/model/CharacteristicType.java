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

    public Long getId() {
        return id;
    }

    public CharacteristicType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public CharacteristicType setType(String type) {
        this.type = type;
        return this;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public CharacteristicType setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
        return this;
    }
}
