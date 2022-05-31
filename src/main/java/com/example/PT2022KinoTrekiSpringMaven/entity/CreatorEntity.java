package com.example.PT2022KinoTrekiSpringMaven.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "creator")
public class CreatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String last_name;
    private String add_names;
}
