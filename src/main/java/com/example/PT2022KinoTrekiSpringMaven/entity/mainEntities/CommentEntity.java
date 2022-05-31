package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long video_id;
    //private Long user_id;
    private String content;
    private Date add_date;
    private Boolean output_state;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "comment",
        cascade = CascadeType.ALL)
    private List<CommentComplaintEntity> complaints;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoEntity video;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
