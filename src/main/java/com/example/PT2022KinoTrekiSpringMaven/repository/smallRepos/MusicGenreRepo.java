package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicGenreRepo extends CrudRepository<MusicGenreEntity, Long> {

    MusicGenreEntity findByName(String name);

    List<MusicGenreEntity> findAll();
}
