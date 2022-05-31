package com.example.PT2022KinoTrekiSpringMaven.entity;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.AgeRatingEntity;
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
    private Time duration;
    private String name;
    private int release_year;
    private String tagline;
    private String description;
    private String poster_path;
    private String trailer_link;
    private Date add_date;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "video",
        cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "video",
        cascade = CascadeType.ALL)
    private List<DefinedVideoGenreEntity> genres;

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
