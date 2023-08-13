package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "coffee_machine_brand")
public class CoffeeMachineBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;


    public Long getId() {
        return id;
    }

    public CoffeeMachineBrand setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CoffeeMachineBrand setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
