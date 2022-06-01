package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.VideoGenre;

public class DefinedVideoGenre {
    private VideoGenre videoGenre;

    static public DefinedVideoGenre toModel(DefinedVideoGenreEntity videoGenre){
        DefinedVideoGenre model = new DefinedVideoGenre();
        model.setVideoGenre(VideoGenre.toModel(videoGenre.getGenre()));
        return model;
    }

    public DefinedVideoGenre() {
    }

    public VideoGenre getVideoGenre() {
        return videoGenre;
    }
    public void setVideoGenre(VideoGenre videoGenre) {
        this.videoGenre = videoGenre;
    }
}
