package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "time_code")
public class TimeCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long music_id;
    //private Long user_id;
    //private Long video_id;
    private Long like_count;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date add_date;
    private Boolean output_state;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time trek_start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Time trek_end;

    @ManyToOne
    @JoinColumn(name = "music_id")
    private MusicEntity music;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoEntity video;
}
