package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CoffeeMachineBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeMachineBrandRepository extends JpaRepository<CoffeeMachineBrand, Long> {

    public List<CoffeeMachineBrand> getAllByOrderByBrand();

}
