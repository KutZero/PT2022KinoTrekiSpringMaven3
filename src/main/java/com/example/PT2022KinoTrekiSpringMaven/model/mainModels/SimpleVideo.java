package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;


import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;

public class SimpleVideo {
    private String name;
    private int release_year;
    private String description;
    private String poster_path;
    //private List<DefinedCreatorEntity> def_creators;
    //private List<DefinedVideoGenreEntity> def_genres;

    public static SimpleVideo toModel(VideoEntity video){
        SimpleVideo model = new SimpleVideo();
        model.setName(video.getName());
        model.setRelease_year(video.getRelease_year());
        model.setDescription(video.getDescription());
        model.setPoster_path(video.getPoster_path());
        //model.setDef_creators(video.getDef_creators());
        //model.setDefGenres(video.getDef_genres());

        return model;
    }

    public SimpleVideo() {
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

    /*public List<DefinedCreatorEntity> getDef_creators() {
        return def_creators;
    }
    public void setDef_creators(List<DefinedCreatorEntity> def_creators) {
        this.def_creators = def_creators;
    }*/

    /*public List<DefinedVideoGenreEntity> getDefGenres() {
        return def_genres;
    }
    public void setDefGenres(List<DefinedVideoGenreEntity> def_genres) {
        this.def_genres = def_genres;
    }*/
}
