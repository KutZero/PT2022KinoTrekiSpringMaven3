package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long video_id;
    private Long user_id;
    private Long review_type_id;
    private String content;
    private Date add_date;
    private Boolean output_state;
}
