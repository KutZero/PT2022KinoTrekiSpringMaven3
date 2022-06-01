package com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<ReviewEntity, Long> {
}
