package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@Table(name = "music")
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long music_genre_id;
    private String name;
    private Time duration;
}
