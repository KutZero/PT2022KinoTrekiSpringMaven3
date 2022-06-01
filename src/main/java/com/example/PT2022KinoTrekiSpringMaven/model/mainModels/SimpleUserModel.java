package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;

public class SimpleUserModel {
    private String login;
    private String photo_path;

    static public SimpleUserModel toModel(UserEntity userEntity){
        SimpleUserModel model = new SimpleUserModel();
        model.setLogin(userEntity.getLogin());
        model.setPhoto_path(userEntity.getPhoto_path());
        return model;
    }

    public SimpleUserModel() {
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoto_path() {
        return photo_path;
    }
    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }
}
