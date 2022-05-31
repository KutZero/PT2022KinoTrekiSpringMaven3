package com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.ReviewTypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReviewTypeRepo extends CrudRepository<ReviewTypeEntity, Long> {
}
