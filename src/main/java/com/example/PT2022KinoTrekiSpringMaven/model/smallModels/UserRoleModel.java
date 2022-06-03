package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import lombok.Data;

@Data
public class UserRoleModel {
    private Long id;
    private String name;

    static public UserRoleModel toModel(UserRoleEntity entity){
        UserRoleModel model = new UserRoleModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

}
