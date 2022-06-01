package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;

public class AgeRatingModel {
    private String rating;

    static public AgeRatingModel toModel(AgeRatingEntity ageRating){
        AgeRatingModel model = new AgeRatingModel();
        model.setRating(ageRating.getRating());
        return model;
    }

    public AgeRatingModel() {
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
}
