package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "comment_complaint")
public class CommentComplaintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long comment_id;
    private String content;
    private Date add_date;
}
