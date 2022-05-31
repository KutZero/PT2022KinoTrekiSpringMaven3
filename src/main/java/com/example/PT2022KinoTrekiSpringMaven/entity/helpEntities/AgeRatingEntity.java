package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "age_rating")
public class AgeRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
}
