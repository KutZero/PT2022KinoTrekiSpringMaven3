package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReviewTypeRepo extends CrudRepository<ReviewTypeEntity, Long> {

    //ReviewTypeEntity findByName(String name);
}
