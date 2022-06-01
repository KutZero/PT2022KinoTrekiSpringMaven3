package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;


import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedCreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedVideoGenreModel;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleVideoModel {
    private String name;
    private int release_year;
    private String description;
    private String poster_path;
    private List<DefinedCreatorModel> def_creators;
    private List<DefinedVideoGenreModel> def_genres;

    public static SimpleVideoModel toModel(VideoEntity video){
        SimpleVideoModel model = new SimpleVideoModel();
        model.setName(video.getName());
        model.setRelease_year(video.getRelease_year());
        model.setDescription(video.getDescription());
        model.setPoster_path(video.getPoster_path());
        model.setDef_creators(video.getDef_creators().stream().map(DefinedCreatorModel::toModel).collect(Collectors.toList()));
        model.setDef_genres(video.getDef_genres().stream().map(DefinedVideoGenreModel::toModel).collect(Collectors.toList()));
        return model;
    }

    public SimpleVideoModel() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRelease_year() {
        return release_year;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster_path() {
        return poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<DefinedCreatorModel> getDef_creators() {
        return def_creators;
    }
    public void setDef_creators(List<DefinedCreatorModel> def_creators) {
        this.def_creators = def_creators;
    }

    public List<DefinedVideoGenreModel> getDef_genres() {
        return def_genres;
    }
    public void setDef_genres(List<DefinedVideoGenreModel> def_genres) {
        this.def_genres = def_genres;
    }

}
