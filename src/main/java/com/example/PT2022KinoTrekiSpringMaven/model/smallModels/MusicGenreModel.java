package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;

public class MusicGenreModel {
    private String name;

    static public MusicGenreModel toModel(MusicGenreEntity musicGenre){
        MusicGenreModel model = new MusicGenreModel();
        model.setName(musicGenre.getName());
        return model;
    }

    public MusicGenreModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
