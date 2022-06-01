package com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.MusicEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepo extends CrudRepository<MusicEntity, Long> {
}
