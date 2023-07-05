package com.vip.coffee.service.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "coffee_machines")
public class CoffeeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unique_machine_number")
    private String uniqueMachineNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private CoffeeMachineModel model;

    @Column(name = "warranty_end_date")
    private LocalDate warrantyEndDate;
}
