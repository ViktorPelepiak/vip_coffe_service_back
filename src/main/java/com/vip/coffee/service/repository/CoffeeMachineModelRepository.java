package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CoffeeMachineBrand;
import com.vip.coffee.service.model.CoffeeMachineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeMachineModelRepository extends JpaRepository<CoffeeMachineModel, Long> {
    Optional<CoffeeMachineModel> findFirstById(Long id);

    List<CoffeeMachineModel> getAllByOrderByBrandAscModelAsc();

    List<CoffeeMachineModel> findAllByBrandOrderByModelAsc(CoffeeMachineBrand brand);
}
