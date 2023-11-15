package com.vip.coffee.service.model;

import javax.persistence.*;

@Entity
@Table(name = "coffee_machine_model")
public class CoffeeMachineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private CoffeeMachineBrand brand;

    private String model;

    public Long getId() {
        return id;
    }

    public CoffeeMachineModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CoffeeMachineBrand getBrand() {
        return brand;
    }

    public CoffeeMachineModel setBrand(CoffeeMachineBrand brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CoffeeMachineModel setModel(String model) {
        this.model = model;
        return this;
    }
}
