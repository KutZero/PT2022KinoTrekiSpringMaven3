package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import lombok.Data;

@Data
public class MusicGenreModel {
    private Long id;
    private String name;

    static public MusicGenreModel toModel(MusicGenreEntity entity){
        MusicGenreModel model = new MusicGenreModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

}
