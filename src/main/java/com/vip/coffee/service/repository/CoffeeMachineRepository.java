package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Long> {

    List<CoffeeMachine> findAllByTemplate(boolean template);

    default List<CoffeeMachine> findAllMachines(){
        return findAllByTemplate(false);
    }

    default List<CoffeeMachine> findAllTemplates(){
        return findAllByTemplate(true);
    }
}
