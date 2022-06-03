package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentComplaintEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class CommentComplaintModel {
    private Long id;
    private String content;
    private Date add_date;
    private SimpleUserModel user;

    static public CommentComplaintModel toModel(CommentComplaintEntity entity){
        CommentComplaintModel model = new CommentComplaintModel();
        model.setId(entity.getId());
        model.setContent(entity.getContent());
        model.setAdd_date(entity.getAdd_date());
        model.setUser(SimpleUserModel.toModel(entity.getUser()));

        return model;
    }

}
