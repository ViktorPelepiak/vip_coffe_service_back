package com.vip.coffee.service.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "coffee_machines")
public class CoffeeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template")
    private boolean template;

    @Column(name = "unique_machine_number")
    private String uniqueMachineNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private CoffeeMachineModel model;

    @Column(name = "warranty_end_date")
    private LocalDate warrantyEndDate;

    @Column(name = "additional_information")
    private String additionalInformation;

    @OneToMany(mappedBy = "coffeeMachine")
    private List<PartCharacteristic> parts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User owner;

    public Long getId() {
        return id;
    }

    public CoffeeMachine setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUniqueMachineNumber() {
        return uniqueMachineNumber;
    }

    public CoffeeMachine setUniqueMachineNumber(String uniqueMachineNumber) {
        this.uniqueMachineNumber = uniqueMachineNumber;
        return this;
    }

    public CoffeeMachineModel getModel() {
        return model;
    }

    public CoffeeMachine setModel(CoffeeMachineModel model) {
        this.model = model;
        return this;
    }

    public LocalDate getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public CoffeeMachine setWarrantyEndDate(LocalDate warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public CoffeeMachine setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public List<PartCharacteristic> getParts() {
        return parts;
    }

    public CoffeeMachine setParts(List<PartCharacteristic> parts) {
        this.parts = parts;
        return this;
    }

    public boolean isTemplate() {
        return template;
    }

    public CoffeeMachine setTemplate(boolean template) {
        this.template = template;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public CoffeeMachine setOwner(User owner) {
        this.owner = owner;
        return this;
    }
}
