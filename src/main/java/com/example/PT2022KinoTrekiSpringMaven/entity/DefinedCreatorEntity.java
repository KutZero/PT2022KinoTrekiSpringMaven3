package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defined_creator")
public class DefinedCreatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long video_id;
    private Long creator_id;
    private Long creator_role_id;
}
