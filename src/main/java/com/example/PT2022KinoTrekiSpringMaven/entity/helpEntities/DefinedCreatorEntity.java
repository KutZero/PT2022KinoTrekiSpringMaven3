package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.VideoEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defined_creator")
public class DefinedCreatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long video_id;
    //private Long creator_id;
    //private Long creator_role_id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoEntity video;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private VideoEntity creator;

    @ManyToOne
    @JoinColumn(name = "creator_role_id")
    private VideoEntity creator_role;
}
