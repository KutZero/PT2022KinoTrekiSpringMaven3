package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;

public class UserRole {
    private String name;

    static public UserRole toModel(UserRoleEntity userRole){
        UserRole model = new UserRole();
        model.setName(userRole.getName());
        return model;
    }

    public UserRole() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
