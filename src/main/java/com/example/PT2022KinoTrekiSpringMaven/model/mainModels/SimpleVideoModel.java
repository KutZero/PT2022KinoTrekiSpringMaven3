package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;


import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedCreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedVideoGenreModel;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SimpleVideoModel {
    private Long id;
    private String name;
    private int release_year;
    private String description;
    private String poster_path;
    private List<DefinedCreatorModel> def_creators;
    private List<DefinedVideoGenreModel> def_genres;

    public static SimpleVideoModel toModel(VideoEntity entity){
        SimpleVideoModel model = new SimpleVideoModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setRelease_year(entity.getRelease_year());
        model.setDescription(entity.getDescription());
        model.setPoster_path(entity.getPoster_path());

        // При добавлении нового видео в базу даже сделать запрос на пустоту этих полей у сущности видео сделать нельзя, так что как то так
        try {
            model.setDef_creators(entity.getDef_creators().stream().map(DefinedCreatorModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        try {
            model.setDef_genres(entity.getDef_genres().stream().map(DefinedVideoGenreModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        return model;
    }

}
