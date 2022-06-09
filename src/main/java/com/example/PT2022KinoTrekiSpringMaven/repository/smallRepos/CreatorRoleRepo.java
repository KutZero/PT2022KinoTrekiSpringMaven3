package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreatorRoleRepo extends CrudRepository<CreatorRoleEntity, Long> {
    CreatorRoleEntity findByName(String name);

    //Long deleteByName(String name);

    List<CreatorRoleEntity> findAll();
}
