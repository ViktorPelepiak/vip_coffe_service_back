package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.PartCharacteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartCharacteristicRepository extends JpaRepository<PartCharacteristic, Long> {
}
