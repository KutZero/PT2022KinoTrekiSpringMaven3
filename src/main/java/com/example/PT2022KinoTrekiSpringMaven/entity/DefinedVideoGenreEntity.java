package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defined_video_genre")
public class DefinedVideoGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long video_genre_id;
    private Long video_id;
}
