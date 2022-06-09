package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defined_creator")
public class DefinedCreatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private VideoEntity video;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private CreatorEntity creator;

    @ManyToOne
    @JoinColumn(name = "creator_role_id")
    private CreatorRoleEntity creatorRole;
}
