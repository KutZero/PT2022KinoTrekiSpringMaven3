package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import lombok.Data;

@Data
public class SimpleUserModel {
    private Long id;
    private String login;
    private String photo_path;

    static public SimpleUserModel toModel(UserEntity entity){
        SimpleUserModel model = new SimpleUserModel();
        model.setId(entity.getId());
        model.setLogin(entity.getLogin());
        model.setPhoto_path(entity.getPhotoPath());
        return model;
    }

}
