package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;

public class CreatorRoleModel {
    private String name;

    static public CreatorRoleModel toModel(CreatorRoleEntity creatorRole){
        CreatorRoleModel model = new CreatorRoleModel();
        model.setName(creatorRole.getName());
        return model;
    }

    public CreatorRoleModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
