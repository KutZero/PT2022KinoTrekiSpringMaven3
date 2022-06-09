package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class CommentModel {
    private Long id;
    private String content;
    private Long like_count;
    private Date add_date;
    private SimpleUserModel simpleUserModel;

    static public CommentModel toModel(CommentEntity entity){
        CommentModel model = new CommentModel();
        model.setId(entity.getId());
        model.setAdd_date(entity.getAddDate());
        model.setContent(entity.getContent());
        model.setLike_count(entity.getLikeCount());
        model.setSimpleUserModel(SimpleUserModel.toModel(entity.getUser()));
        return model;
    }

}
