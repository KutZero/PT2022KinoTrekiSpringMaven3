package com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.AgeRatingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgeRatingRepo extends CrudRepository<AgeRatingEntity, Long> {

    //@Query("SELECT * FROM age_rating WHERE rating = :rating")
    //AgeRatingEntity findByRating(@Param("rating") Long rating);

    AgeRatingEntity findByRating(int rating);

    //Long deleteByRating(int rating); // Не работает
}
