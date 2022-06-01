package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.MusicEntity;

import java.sql.Time;

public class SimpleMusicModel {
    private String name;
    private String group_name;
    private Time duration;

    static public SimpleMusicModel toModel(MusicEntity musicEntity){
        SimpleMusicModel model = new SimpleMusicModel();
        model.setName(musicEntity.getName());
        model.setGroup_name(musicEntity.getGroup_name());
        model.setDuration(musicEntity.getDuration());
        return model;
    }

    public SimpleMusicModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGroup_name() {
        return group_name;
    }
    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Time getDuration() {
        return duration;
    }
    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
