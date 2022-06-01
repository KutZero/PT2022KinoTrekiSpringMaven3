package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;

import java.sql.Date;

public class CommentModel {
    private String content;
    private Long like_count;
    private Date add_date;
    private SimpleUserModel simpleUserModel;

    static public CommentModel toModel(CommentEntity commentEntity){
        CommentModel model = new CommentModel();
        model.setAdd_date(commentEntity.getAdd_date());
        model.setContent(commentEntity.getContent());
        model.setLike_count(commentEntity.getLike_count());
        model.setSimpleUser(SimpleUserModel.toModel(commentEntity.getUser()));
        return model;
    }

    public CommentModel() {
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

    public SimpleUserModel getSimpleUser() {
        return simpleUserModel;
    }
    public void setSimpleUser(SimpleUserModel simpleUserModel) {
        this.simpleUserModel = simpleUserModel;
    }
}
