package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;

public class ReviewTypeModel {
    private String name;

    static public ReviewTypeModel toModel(ReviewTypeEntity reviewType){
        ReviewTypeModel model = new ReviewTypeModel();
        model.setName(reviewType.getName());
        return model;
    }

    public ReviewTypeModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
