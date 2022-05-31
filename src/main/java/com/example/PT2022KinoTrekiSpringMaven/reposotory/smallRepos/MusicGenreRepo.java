package com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicGenreRepo extends CrudRepository<MusicGenreEntity, Long> {

    MusicGenreEntity findByName(String name);
}
