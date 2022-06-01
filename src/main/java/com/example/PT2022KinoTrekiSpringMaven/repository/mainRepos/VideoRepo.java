package com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepo extends CrudRepository<VideoEntity, Long> {

    //VideoEntity findByName(String name);
}
