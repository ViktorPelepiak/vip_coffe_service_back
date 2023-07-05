package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "coffee_machine_brand")
public class CoffeeMachineBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
}
