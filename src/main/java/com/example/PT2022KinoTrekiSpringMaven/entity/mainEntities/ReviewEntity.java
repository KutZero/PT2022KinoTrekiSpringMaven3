package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String content;
    @JoinColumn(name = "like_count")
    private Long likeCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JoinColumn(name = "add_date")
    private Date addDate;
    @JoinColumn(name = "output_state")
    private Boolean outputState;

    @ManyToOne
    @JoinColumn(name = "review_type_id")
    private ReviewTypeEntity reviewType;

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
