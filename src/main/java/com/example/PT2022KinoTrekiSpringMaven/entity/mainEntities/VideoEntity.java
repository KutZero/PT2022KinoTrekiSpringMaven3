package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
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
    //private Long age_rating_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time duration;
    private String name;
    private int release_year;
    private String tagline;
    private String description;
    private String poster_path;
    private String trailer_link;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date add_date;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "video",
        cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "video",
        cascade = CascadeType.ALL)
    private List<DefinedVideoGenreEntity> def_genres;

    @ManyToOne
    @JoinColumn(name = "age_rating_id")
    private AgeRatingEntity rating;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<TimeCodeEntity> time_codes;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<DefinedCreatorEntity> def_creators;
}
