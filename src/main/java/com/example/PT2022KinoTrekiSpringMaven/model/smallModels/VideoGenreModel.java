package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import lombok.Data;

@Data
public class VideoGenreModel {
    private Long id;
    private String name;

    static public VideoGenreModel toModel(VideoGenreEntity entity){
        VideoGenreModel model = new VideoGenreModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }
}
