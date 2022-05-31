package com.example.PT2022KinoTrekiSpringMaven.reposotory;

import com.example.PT2022KinoTrekiSpringMaven.entity.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoRepo extends CrudRepository<VideoEntity, Long> {

    //VideoEntity findByName(String name);
}
