package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "creator",
        cascade = CascadeType.ALL)
    private List<DefinedCreatorEntity> def_creators;
}
