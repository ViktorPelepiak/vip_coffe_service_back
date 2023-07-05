package com.vip.coffee.service.model;

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

    @Column(name = "value")
    private Float characteristicValue;
}
