package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;

public class CreatorRole {
    private String name;

    static public CreatorRole toModel(CreatorRoleEntity creatorRole){
        CreatorRole model = new CreatorRole();
        model.setName(creatorRole.getName());
        return model;
    }

    public CreatorRole() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
