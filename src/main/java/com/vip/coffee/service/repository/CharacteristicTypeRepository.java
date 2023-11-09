package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CharacteristicType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacteristicTypeRepository extends JpaRepository<CharacteristicType, Long> {
    List<CharacteristicType> getAllByOrderByTypeAscMeasurementUnit();

    Optional<CharacteristicType> findFirstByTypeAndMeasurementUnit(String type, String measurementUnit);
}
