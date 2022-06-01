package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.Creator;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CreatorRole;

public class DefinedCreator {
    //private VideoEntity videoEntity;
    private Creator creator;
    private CreatorRole creatorRole;

    static public DefinedCreator toModel(DefinedCreatorEntity creator){
        DefinedCreator model = new DefinedCreator();
        model.setCreator(Creator.toModel(creator.getCreator()));
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

    public Creator getCreator() {
        return creator;
    }
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public CreatorRole getCreatorRole() {
        return creatorRole;
    }
    public void setCreatorRole(CreatorRole creatorRole) {
        this.creatorRole = creatorRole;
    }
}
