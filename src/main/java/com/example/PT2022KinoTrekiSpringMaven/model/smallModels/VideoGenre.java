package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;

public class VideoGenre {
    private String name;

    static public VideoGenre toModel(VideoGenreEntity videoGenre){
        VideoGenre model = new VideoGenre();
        model.setName(videoGenre.getName());
        return model;
    }

    public VideoGenre() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
