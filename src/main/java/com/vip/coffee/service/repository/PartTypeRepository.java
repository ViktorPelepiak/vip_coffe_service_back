package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.PartType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartTypeRepository extends JpaRepository<PartType, Long> {
    List<PartType> getAllByOrderByType();

    Optional<PartType> findFirstByType(String partType);
}
