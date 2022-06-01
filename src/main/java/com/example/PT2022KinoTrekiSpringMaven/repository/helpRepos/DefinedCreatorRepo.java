package com.example.PT2022KinoTrekiSpringMaven.repository.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DefinedCreatorRepo extends CrudRepository<DefinedCreatorEntity, Long> {

    //Boolean existsByVideoidAndCreatoridAndCreatorroleid(Long video_id, Long creator_id, Long creator_role_id);

}
