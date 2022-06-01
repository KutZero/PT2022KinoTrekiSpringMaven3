package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.VideoGenreModel;

public class DefinedVideoGenreModel {
    private VideoGenreModel videoGenreModel;

    static public DefinedVideoGenreModel toModel(DefinedVideoGenreEntity videoGenre){
        DefinedVideoGenreModel model = new DefinedVideoGenreModel();
        model.setVideoGenre(VideoGenreModel.toModel(videoGenre.getGenre()));
        return model;
    }

    public DefinedVideoGenreModel() {
    }

    public VideoGenreModel getVideoGenre() {
        return videoGenreModel;
    }
    public void setVideoGenre(VideoGenreModel videoGenreModel) {
        this.videoGenreModel = videoGenreModel;
    }
}
