package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.ReviewTypeModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class ReviewModel {
    private Long id;
    private String content;
    private Long like_count;
    private Date add_date;
    private SimpleUserModel user;
    private ReviewTypeModel review_type;

    static public ReviewModel toModel(ReviewEntity entity){
        ReviewModel model = new ReviewModel();
        model.setId(entity.getId());
        model.setContent(entity.getContent());
        model.setLike_count(entity.getLike_count());
        model.setAdd_date(entity.getAdd_date());
        model.setUser(SimpleUserModel.toModel(entity.getUser()));
        model.setReview_type(ReviewTypeModel.toModel(entity.getReview_type()));

        return model;
    }

}
