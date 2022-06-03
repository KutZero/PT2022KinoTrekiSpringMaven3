package com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CountryEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {

    List<CountryEntity> findAll();
}
