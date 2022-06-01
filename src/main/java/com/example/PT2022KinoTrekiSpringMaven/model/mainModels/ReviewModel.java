package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.ReviewTypeModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ReviewModel {
    private String content;
    private Long like_count;
    private Date add_date;
    private SimpleUserModel user;
    private ReviewTypeModel review_type;

    static public ReviewModel toModel(ReviewEntity reviewEntity){
        ReviewModel model = new ReviewModel();
        model.setContent(reviewEntity.getContent());
        model.setLike_count(reviewEntity.getLike_count());
        model.setAdd_date(reviewEntity.getAdd_date());
        model.setUser(SimpleUserModel.toModel(reviewEntity.getUser()));
        model.setReview_type(ReviewTypeModel.toModel(reviewEntity.getReview_type()));

        return model;
    }

    public ReviewModel() {
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Long getLike_count() {
        return like_count;
    }
    public void setLike_count(Long like_count) {
        this.like_count = like_count;
    }

    public Date getAdd_date() {
        return add_date;
    }
    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public SimpleUserModel getUser() {
        return user;
    }
    public void setUser(SimpleUserModel user) {
        this.user = user;
    }

    public ReviewTypeModel getReview_type() {
        return review_type;
    }
    public void setReview_type(ReviewTypeModel review_type) {
        this.review_type = review_type;
    }
}
