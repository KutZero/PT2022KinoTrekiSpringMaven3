package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import lombok.Data;

@Data
public class ReviewTypeModel {
    private Long id;
    private String name;

    static public ReviewTypeModel toModel(ReviewTypeEntity entity){
        ReviewTypeModel model = new ReviewTypeModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

}
