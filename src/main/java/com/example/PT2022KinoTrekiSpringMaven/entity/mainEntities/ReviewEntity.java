package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long video_id;
    //private Long user_id;
    //private Long review_type_id;
    private String content;
    private Date add_date;
    private Boolean output_state;

    @ManyToOne
    @JoinColumn(name = "review_type_id")
    private ReviewTypeEntity review_type;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoEntity video;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "review",
        cascade = CascadeType.ALL)
    private List<ReviewComplaintEntity> complaints;
}
