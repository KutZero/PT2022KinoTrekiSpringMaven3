package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import lombok.Data;

@Data
public class AgeRatingModel {
    private Long id;
    private String rating;

    static public AgeRatingModel toModel(AgeRatingEntity entity){
        AgeRatingModel model = new AgeRatingModel();
        model.setId(entity.getId());
        model.setRating(entity.getRating());
        return model;
    }

}
