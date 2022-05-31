package com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.CreatorRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface CreatorRoleRepo extends CrudRepository<CreatorRoleEntity, Long> {
    CreatorRoleEntity findByName(String name);

    //Long deleteByName(String name);
}
