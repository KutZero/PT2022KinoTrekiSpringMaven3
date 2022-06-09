package com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoRepo extends CrudRepository<VideoEntity, Long> {

    //VideoEntity findByName(String name);

    //List<VideoEntity> findByNameIgnoreCase(String name, Pageable page);

    //List<VideoEntity> findAll(Pageable page);
    Page<VideoEntity> findAll(Pageable page);

    Page<VideoEntity> findByReleaseYear(Pageable page, int year);

}
