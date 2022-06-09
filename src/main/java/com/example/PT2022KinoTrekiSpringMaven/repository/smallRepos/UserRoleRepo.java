package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepo extends CrudRepository<UserRoleEntity, Long> {
    UserRoleEntity findByName(String name);

    List<UserRoleEntity> findAll();
}
