package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.CreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CreatorRoleModel;

public class DefinedCreatorModel {
    private CreatorModel creatorModel;
    private CreatorRoleModel creatorRoleModel;

    static public DefinedCreatorModel toModel(DefinedCreatorEntity creator){
        DefinedCreatorModel model = new DefinedCreatorModel();
        model.setCreator(CreatorModel.toModel(creator.getCreator()));
        model.setCreatorRole(CreatorRoleModel.toModel(creator.getCreator_role()));
        return model;
    }

    public DefinedCreatorModel() {
    }

    public CreatorModel getCreator() {
        return creatorModel;
    }
    public void setCreator(CreatorModel creatorModel) {
        this.creatorModel = creatorModel;
    }

    public CreatorRoleModel getCreatorRole() {
        return creatorRoleModel;
    }
    public void setCreatorRole(CreatorRoleModel creatorRoleModel) {
        this.creatorRoleModel = creatorRoleModel;
    }
}
