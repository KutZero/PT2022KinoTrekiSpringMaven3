package com.example.PT2022KinoTrekiSpringMaven.reposotory.mainRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    //UserEntity findByUsername(String username);

}
