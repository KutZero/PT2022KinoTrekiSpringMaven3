package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedCreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedVideoGenreModel;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

public class ExtendedVideoModel {
    private Time duration;
    private String name;
    private int release_year;
    private String tagline;
    private String description;
    private String poster_path;
    private String trailer_link;
    private Date add_date;
    private List<DefinedCreatorModel> def_creators;
    private List<DefinedVideoGenreModel> def_genres;
    private List<CommentModel> comments;
    private List<TimeCodeModel> time_codes;
    private List<ReviewModel> reviews;

    static public ExtendedVideoModel toModel(VideoEntity video){
        ExtendedVideoModel model = new ExtendedVideoModel();
        model.setDuration(video.getDuration());
        model.setName(video.getName());
        model.setRelease_year(video.getRelease_year());
        model.setTagline(video.getTagline());
        model.setDescription(video.getDescription());
        model.setPoster_path(video.getPoster_path());
        model.setTrailer_link(video.getTrailer_link());
        model.setDef_creators(video.getDef_creators().stream().map(DefinedCreatorModel::toModel).collect(Collectors.toList()));
        model.setDef_genres(video.getDef_genres().stream().map(DefinedVideoGenreModel::toModel).collect(Collectors.toList()));
        model.setComments(video.getComments().stream().map(CommentModel::toModel).collect(Collectors.toList()));
        model.setTime_codes(video.getTime_codes().stream().map(TimeCodeModel::toModel).collect(Collectors.toList()));
        model.setReviews(video.getReviews().stream().map(ReviewModel::toModel).collect(Collectors.toList()));

        return model;
    }

    public ExtendedVideoModel() {

    }

    public Time getDuration() {
        return duration;
    }
    public void setDuration(Time duration) {
        this.duration = duration;
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

    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
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

    public String getTrailer_link() {
        return trailer_link;
    }
    public void setTrailer_link(String trailer_link) {
        this.trailer_link = trailer_link;
    }

    public Date getAdd_date() {
        return add_date;
    }
    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
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

    public List<CommentModel> getComments() {
        return comments;
    }
    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<TimeCodeModel> getTime_codes() {
        return time_codes;
    }
    public void setTime_codes(List<TimeCodeModel> time_codes) {
        this.time_codes = time_codes;
    }

    public List<ReviewModel> getReviews() {
        return reviews;
    }
    public void setReviews(List<ReviewModel> reviews) {
        this.reviews = reviews;
    }
}
