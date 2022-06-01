package com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<CommentEntity, Long> {
}
