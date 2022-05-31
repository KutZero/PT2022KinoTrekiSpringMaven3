package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "creator_role")
public class ReviewTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
