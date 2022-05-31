package com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepo extends CrudRepository<UserRoleEntity, Long> {
}
