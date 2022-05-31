package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.ReviewEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "creator_role")
public class ReviewTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "review_type",
        cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;
}
