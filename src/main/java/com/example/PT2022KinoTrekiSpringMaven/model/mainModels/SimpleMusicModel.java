package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.MusicEntity;
import lombok.Data;

import java.sql.Time;

@Data
public class SimpleMusicModel {
    private Long id;
    private String name;
    private String group_name;
    private Time duration;

    static public SimpleMusicModel toModel(MusicEntity entity){
        SimpleMusicModel model = new SimpleMusicModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setGroup_name(entity.getGroupName());
        model.setDuration(entity.getDuration());
        return model;
    }

}
