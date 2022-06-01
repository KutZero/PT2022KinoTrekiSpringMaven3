package com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "age_rating")
public class AgeRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rating;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "rating",
        cascade = CascadeType.ALL)
    private List<VideoEntity> video;
}
