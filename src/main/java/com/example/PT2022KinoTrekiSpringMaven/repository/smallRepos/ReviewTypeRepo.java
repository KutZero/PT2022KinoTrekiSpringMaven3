package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewTypeRepo extends CrudRepository<ReviewTypeEntity, Long> {

    //ReviewTypeEntity findByName(String name);

    List<ReviewTypeEntity> findAll();
}
