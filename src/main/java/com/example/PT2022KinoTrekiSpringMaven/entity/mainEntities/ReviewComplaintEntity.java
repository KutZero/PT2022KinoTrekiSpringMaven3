package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "review_complaint")
public class ReviewComplaintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long user_id;
    //private Long review_id;
    private String content;
    private Date add_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private ReviewEntity review;
}