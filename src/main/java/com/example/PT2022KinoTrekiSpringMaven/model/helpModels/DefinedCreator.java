package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.CreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CreatorRole;

public class DefinedCreator {
    //private VideoEntity videoEntity;
    private CreatorModel creatorModel;
    private CreatorRole creatorRole;

    static public DefinedCreator toModel(DefinedCreatorEntity creator){
        DefinedCreator model = new DefinedCreator();
        model.setCreator(CreatorModel.toModel(creator.getCreator()));
        model.setCreatorRole(CreatorRole.toModel(creator.getCreator_role()));
        //model.setVideoEntity(creator.getVideo());
        return model;
    }

    public DefinedCreator() {
    }

    /*public VideoEntity getVideoEntity() {
        return videoEntity;
    }
    public void setVideoEntity(VideoEntity videoEntity) {
        this.videoEntity = videoEntity;
    }*/

    public CreatorModel getCreator() {
        return creatorModel;
    }
    public void setCreator(CreatorModel creatorModel) {
        this.creatorModel = creatorModel;
    }

    public CreatorRole getCreatorRole() {
        return creatorRole;
    }
    public void setCreatorRole(CreatorRole creatorRole) {
        this.creatorRole = creatorRole;
    }
}
