package com.example.PT2022KinoTrekiSpringMaven.model.helpModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.VideoGenreModel;
import lombok.Data;

@Data
public class DefinedVideoGenreModel {
    private Long id;
    private VideoGenreModel videoGenreModel;

    static public DefinedVideoGenreModel toModel(DefinedVideoGenreEntity entity){
        DefinedVideoGenreModel model = new DefinedVideoGenreModel();
        model.setId(entity.getId());
        model.setVideoGenreModel(VideoGenreModel.toModel(entity.getGenre()));
        return model;
    }

}
