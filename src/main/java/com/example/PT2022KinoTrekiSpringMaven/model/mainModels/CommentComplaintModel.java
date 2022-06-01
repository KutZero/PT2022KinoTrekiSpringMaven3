package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentComplaintEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class CommentComplaintModel {
    private String content;
    private Date add_date;
    private SimpleUserModel user;

    static public CommentComplaintModel toModel(CommentComplaintEntity commentComplaint){
        CommentComplaintModel model = new CommentComplaintModel();
        model.setContent(commentComplaint.getContent());
        model.setAdd_date(commentComplaint.getAdd_date());
        model.setUser(SimpleUserModel.toModel(commentComplaint.getUser()));

        return model;
    }

    public CommentComplaintModel() {
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
