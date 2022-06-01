package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;

public class AgeRating {
    private String rating;

    static public AgeRating toModel(AgeRatingEntity ageRating){
        AgeRating model = new AgeRating();
        model.setRating(ageRating.getRating());
        return model;
    }

    public AgeRating() {
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
}
