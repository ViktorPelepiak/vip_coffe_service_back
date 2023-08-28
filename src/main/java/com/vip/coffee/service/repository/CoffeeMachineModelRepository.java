package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CoffeeMachineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeMachineModelRepository extends JpaRepository<CoffeeMachineModel, Long> {
    List<CoffeeMachineModel> getAllByOrderByBrandAscModelAsc();
}
