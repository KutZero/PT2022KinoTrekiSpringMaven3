package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewComplaintEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class ReviewComplaintModel {
    private Long id;
    private String content;
    private Date add_date;
    private SimpleUserModel user;

    static public ReviewComplaintModel toModel(ReviewComplaintEntity entity){
        ReviewComplaintModel model = new ReviewComplaintModel();
        model.setId(entity.getId());
        model.setContent(entity.getContent());
        model.setAdd_date(entity.getAdd_date());
        model.setUser(SimpleUserModel.toModel(entity.getUser()));

        return model;
    }

}
