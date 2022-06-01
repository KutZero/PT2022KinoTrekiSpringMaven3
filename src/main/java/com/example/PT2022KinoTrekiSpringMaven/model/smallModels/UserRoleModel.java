package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;

public class UserRoleModel {
    private String name;

    static public UserRoleModel toModel(UserRoleEntity userRole){
        UserRoleModel model = new UserRoleModel();
        model.setName(userRole.getName());
        return model;
    }

    public UserRoleModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
