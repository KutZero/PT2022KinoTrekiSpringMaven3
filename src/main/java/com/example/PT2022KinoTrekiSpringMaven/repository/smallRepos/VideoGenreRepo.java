package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoGenreRepo extends CrudRepository<VideoGenreEntity, Long> {
    VideoGenreEntity findByName(String name);

    List<VideoGenreEntity> findAll();
}
