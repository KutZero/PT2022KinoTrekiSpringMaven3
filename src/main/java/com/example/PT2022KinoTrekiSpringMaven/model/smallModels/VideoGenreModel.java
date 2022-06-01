package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;

public class VideoGenreModel {
    private String name;

    static public VideoGenreModel toModel(VideoGenreEntity videoGenre){
        VideoGenreModel model = new VideoGenreModel();
        model.setName(videoGenre.getName());
        return model;
    }

    public VideoGenreModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
