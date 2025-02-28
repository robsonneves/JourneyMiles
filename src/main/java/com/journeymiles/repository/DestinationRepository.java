package com.journeymiles.repository;

import com.journeymiles.entity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {

    List<DestinationEntity> findByNameContains(String name);
}
