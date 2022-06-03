package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import lombok.Data;

@Data
public class CreatorModel {
    private Long id;
    private String name;
    private String last_name;
    private String add_names;

    public static CreatorModel toModel(CreatorEntity entity){
        CreatorModel model = new CreatorModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setAdd_names(entity.getAdd_names());
        model.setLast_name(entity.getLast_name());
        return model;
    }

}
