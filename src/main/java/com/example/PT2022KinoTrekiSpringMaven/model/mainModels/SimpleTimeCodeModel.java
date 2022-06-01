package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.TimeCodeEntity;

import java.sql.Date;
import java.sql.Time;

public class SimpleTimeCodeModel {
    private Long like_count;
    private Date add_date;
    private Time trek_start;
    private Time trek_end;
    private SimpleUserModel user;

    static public SimpleTimeCodeModel toModel(TimeCodeEntity timeCodeEntity){
        SimpleTimeCodeModel model = new SimpleTimeCodeModel();
        model.setLike_count(timeCodeEntity.getLike_count());
        model.setAdd_date(timeCodeEntity.getAdd_date());
        model.setTrek_start(timeCodeEntity.getTrek_start());
        model.setTrek_end(timeCodeEntity.getTrek_end());
        model.setUser(SimpleUserModel.toModel(timeCodeEntity.getUser()));
        return model;
    }

    public SimpleTimeCodeModel() {
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

    public Time getTrek_start() {
        return trek_start;
    }
    public void setTrek_start(Time trek_start) {
        this.trek_start = trek_start;
    }

    public Time getTrek_end() {
        return trek_end;
    }
    public void setTrek_end(Time trek_end) {
        this.trek_end = trek_end;
    }

    public SimpleUserModel getUser() {
        return user;
    }
    public void setUser(SimpleUserModel user) {
        this.user = user;
    }
}
