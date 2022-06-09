package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defined_video_genre")
public class DefinedVideoGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoEntity video;

    @ManyToOne
    @JoinColumn(name = "video_genre_id")
    private VideoGenreEntity genre;
}
