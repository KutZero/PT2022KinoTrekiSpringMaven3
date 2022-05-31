package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "video")
public class VideoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long age_rating_id;
    private Time duration;
    private String name;
    private int release_year;
    private String tagline;
    private String description;
    private String poster_path;
    private String trailer_link;
    private Date add_date;
}
