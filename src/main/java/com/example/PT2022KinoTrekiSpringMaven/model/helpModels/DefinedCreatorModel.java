package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.CreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CreatorRoleModel;
import lombok.Data;

@Data
public class DefinedCreatorModel {
    private Long id;
    private CreatorModel creatorModel;
    private CreatorRoleModel creatorRoleModel;

    static public DefinedCreatorModel toModel(DefinedCreatorEntity entity){
        DefinedCreatorModel model = new DefinedCreatorModel();
        model.setId(entity.getId());
        model.setCreatorModel(CreatorModel.toModel(entity.getCreator()));
        model.setCreatorRoleModel(CreatorRoleModel.toModel(entity.getCreator_role()));
        return model;
    }
}
