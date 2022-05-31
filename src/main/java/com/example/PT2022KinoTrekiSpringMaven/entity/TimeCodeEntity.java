package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "time_code")
public class TimeCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long music_id;
    private Long user_id;
    private Long video_id;
    private Long like_count;
    private Date add_date;
    private Boolean output_state;
}
