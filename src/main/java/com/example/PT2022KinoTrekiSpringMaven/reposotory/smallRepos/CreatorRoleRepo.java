package com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface CreatorRoleRepo extends CrudRepository<CreatorRoleEntity, Long> {
    CreatorRoleEntity findByName(String name);

    //Long deleteByName(String name);
}
