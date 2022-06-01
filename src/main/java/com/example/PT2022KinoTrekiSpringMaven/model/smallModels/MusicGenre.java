package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;

public class MusicGenre {
    private String name;

    static public MusicGenre toModel(MusicGenreEntity musicGenre){
        MusicGenre model = new MusicGenre();
        model.setName(musicGenre.getName());
        return model;
    }

    public MusicGenre() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
