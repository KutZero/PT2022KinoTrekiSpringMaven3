package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;

import java.sql.Date;

public class Comment {
    private String content;
    private Long like_count;
    private Date add_date;

    static public Comment toModel(CommentEntity commentEntity){
        Comment model = new Comment();
        model.setAdd_date(commentEntity.getAdd_date());
        model.setContent(commentEntity.getContent());
        model.setLike_count(commentEntity.getLike_count());
        return model;
    }

    public Comment() {
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
}
