package com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.MusicGenreEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicGenreRepo extends CrudRepository<MusicGenreEntity, Long> {

}
