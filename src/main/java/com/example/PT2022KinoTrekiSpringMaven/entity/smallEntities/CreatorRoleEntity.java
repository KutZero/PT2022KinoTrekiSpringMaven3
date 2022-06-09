package com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "creator_role")
public class CreatorRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "creatorRole",
            cascade = CascadeType.ALL)
    private List<DefinedCreatorEntity> defCreators;
}
