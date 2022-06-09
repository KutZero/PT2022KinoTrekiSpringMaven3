package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CountryEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "video")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time duration;
    private String name;
    @JoinColumn(name = "release_year")
    private int releaseYear;
    private String tagline;
    private String description;
    @JoinColumn(name = "poster_path")
    private String posterPath;
    @JoinColumn(name = "trailer_link")
    private String trailerLink;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JoinColumn(name = "add_date")
    private Date addDate;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "video",
        cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "video",
        cascade = CascadeType.ALL)
    private List<DefinedVideoGenreEntity> defGenres;

    @ManyToOne
    @JoinColumn(name = "age_rating_id")
    private AgeRatingEntity rating;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<TimeCodeEntity> timeCodes;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<DefinedCreatorEntity> defCreators;
}
