package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@Table(name = "music")
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long music_genre_id;
    private String name;
    private Time duration;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "music",
        cascade = CascadeType.ALL)
    private List<TimeCodeEntity> time_codes;

    @ManyToOne
    @JoinColumn(name = "music_genre_id")
    private MusicGenreEntity genre;
}
