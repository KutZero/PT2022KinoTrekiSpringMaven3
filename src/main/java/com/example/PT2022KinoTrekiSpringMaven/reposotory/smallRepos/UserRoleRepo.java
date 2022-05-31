package com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepo extends CrudRepository<UserRoleEntity, Long> {
    UserRoleEntity findByName(String name);
}
