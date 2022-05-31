package com.example.PT2022KinoTrekiSpringMaven.reposotory;

import com.example.PT2022KinoTrekiSpringMaven.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    //UserEntity findByUsername(String username);

}
