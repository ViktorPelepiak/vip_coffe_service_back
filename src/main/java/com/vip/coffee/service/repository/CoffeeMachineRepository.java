package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Long> {

    List<CoffeeMachine> findAllByTemplate(boolean template);

    default List<CoffeeMachine> findAllMachines(){
        return findAllByTemplate(false);
    }

    default List<CoffeeMachine> findAllTemplates(){
        return findAllByTemplate(true);
    }

    Optional<CoffeeMachine> findFirstByIdAndTemplate(Long id, boolean template);

    default Optional<CoffeeMachine> findFirstTemplateById(Long templateId) {
        return findFirstByIdAndTemplate(templateId, true);
    }

    Optional<CoffeeMachine> findFirstByUniqueMachineNumber(String uniqMachineNumber);
}
