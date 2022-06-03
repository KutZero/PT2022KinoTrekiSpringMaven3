package com.example.PT2022KinoTrekiSpringMaven.model.mainModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedCreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedVideoGenreModel;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ExtendedVideoModel {
    private Long id;
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

    static public ExtendedVideoModel toModel(VideoEntity entity){
        ExtendedVideoModel model = new ExtendedVideoModel();
        model.setId(entity.getId());
        model.setDuration(entity.getDuration());
        model.setName(entity.getName());
        model.setRelease_year(entity.getRelease_year());
        model.setTagline(entity.getTagline());
        model.setDescription(entity.getDescription());
        model.setPoster_path(entity.getPoster_path());
        model.setTrailer_link(entity.getTrailer_link());

        try {
            model.setDef_creators(entity.getDef_creators().stream().map(DefinedCreatorModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        try {
            model.setDef_genres(entity.getDef_genres().stream().map(DefinedVideoGenreModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        try {
            model.setComments(entity.getComments().stream().map(CommentModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        try {
            model.setTime_codes(entity.getTime_codes().stream().map(TimeCodeModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        try {
            model.setReviews(entity.getReviews().stream().map(ReviewModel::toModel).collect(Collectors.toList()));
        }
        catch (Exception ignored){}

        return model;
    }

}
