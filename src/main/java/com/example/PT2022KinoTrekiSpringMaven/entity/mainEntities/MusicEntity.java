package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String group_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time duration;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "music",
        cascade = CascadeType.ALL)
    private List<TimeCodeEntity> time_codes;

    @ManyToOne
    @JoinColumn(name = "music_genre_id")
    private MusicGenreEntity genre;
}
