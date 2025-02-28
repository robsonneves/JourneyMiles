package com.journeymiles.repository;

import com.journeymiles.entity.TestimonyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestimonyRepository extends JpaRepository<TestimonyEntity, Long> {

    @Query(nativeQuery=true, value="SELECT * FROM TESTIMONY ORDER BY random() LIMIT 3")
    List<TestimonyEntity> findRandomTestimony();
}
