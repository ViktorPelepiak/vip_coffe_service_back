package com.vip.coffee.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "part_characteristic")
public class PartCharacteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_type_id")
    private PartType partType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characteristic_type_id")
    private CharacteristicType characteristicType;

    @Column(name = "char_value")
    private String characteristicValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coffe_machine_id")
    @JsonIgnore
    private CoffeeMachine coffeeMachine;

    public Long getId() {
        return id;
    }

    public PartCharacteristic setId(Long id) {
        this.id = id;
        return this;
    }

    public PartType getPartType() {
        return partType;
    }

    public PartCharacteristic setPartType(PartType partType) {
        this.partType = partType;
        return this;
    }

    public CharacteristicType getCharacteristicType() {
        return characteristicType;
    }

    public PartCharacteristic setCharacteristicType(CharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
        return this;
    }

    public String getCharacteristicValue() {
        return characteristicValue;
    }

    public PartCharacteristic setCharacteristicValue(String characteristicValue) {
        this.characteristicValue = characteristicValue;
        return this;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public PartCharacteristic setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        return this;
    }
}
