package com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import org.springframework.data.repository.CrudRepository;

public interface AgeRatingRepo extends CrudRepository<AgeRatingEntity, Long> {

    //@Query("SELECT * FROM age_rating WHERE rating = :rating")
    //AgeRatingEntity findByRating(@Param("rating") Long rating);

    AgeRatingEntity findByRating(int rating);

    //Long deleteByRating(int rating); // Не работает
}
