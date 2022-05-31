package com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.VideoGenreEntity;
import org.springframework.data.repository.CrudRepository;

public interface VideoGenreRepo extends CrudRepository<VideoGenreEntity, Long> {
}
