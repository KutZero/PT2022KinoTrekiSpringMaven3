package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewComplaintEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class ReviewComplaintModel {
    private String content;
    private Date add_date;
    private SimpleUserModel user;

    static public ReviewComplaintModel toModel(ReviewComplaintEntity reviewComplaint){
        ReviewComplaintModel model = new ReviewComplaintModel();
        model.setContent(reviewComplaint.getContent());
        model.setAdd_date(reviewComplaint.getAdd_date());
        model.setUser(SimpleUserModel.toModel(reviewComplaint.getUser()));

        return model;
    }

    public ReviewComplaintModel() {
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
}
