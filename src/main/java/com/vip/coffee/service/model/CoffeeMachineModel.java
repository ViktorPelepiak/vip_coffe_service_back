package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "coffee_machine_model")
public class CoffeeMachineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private CoffeeMachineBrand brand;

    private String model;
}
