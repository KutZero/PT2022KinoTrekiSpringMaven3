package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;

public class ReviewType {
    private String name;

    static public ReviewType toModel(ReviewTypeEntity reviewType){
        ReviewType model = new ReviewType();
        model.setName(reviewType.getName());
        return model;
    }

    public ReviewType() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
