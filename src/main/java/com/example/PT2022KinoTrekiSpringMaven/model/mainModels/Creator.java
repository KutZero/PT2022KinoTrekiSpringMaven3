package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;

public class Creator {
    private String name;
    private String last_name;
    private String add_names;

    public static Creator toModel(CreatorEntity creator){
        Creator model = new Creator();
        model.setName(creator.getName());
        model.setAdd_names(creator.getAdd_names());
        model.setLast_name(creator.getLast_name());
        return model;
    }

    public Creator() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAdd_names() {
        return add_names;
    }
    public void setAdd_names(String add_names) {
        this.add_names = add_names;
    }
}
