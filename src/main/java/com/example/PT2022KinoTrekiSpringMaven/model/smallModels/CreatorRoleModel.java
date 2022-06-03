package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import lombok.Data;

@Data
public class CreatorRoleModel {
    private Long id;
    private String name;

    static public CreatorRoleModel toModel(CreatorRoleEntity entity){
        CreatorRoleModel model = new CreatorRoleModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

}
