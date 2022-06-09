package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.TimeCodeEntity;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class TimeCodeModel {
    private Long id;
    private Long like_count;
    private Date add_date;
    private Time trek_start;
    private Time trek_end;
    private SimpleUserModel user;

    static public TimeCodeModel toModel(TimeCodeEntity entity){
        TimeCodeModel model = new TimeCodeModel();
        model.setId(entity.getId());
        model.setLike_count(entity.getLikeCount());
        model.setAdd_date(entity.getAddDate());
        model.setTrek_start(entity.getTrekStart());
        model.setTrek_end(entity.getTrekEnd());
        model.setUser(SimpleUserModel.toModel(entity.getUser()));
        return model;
    }

}
