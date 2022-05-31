package com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.DefinedVideoGenreEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "creator_role")
public class VideoGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "genre",
        cascade = CascadeType.ALL)
    private List<DefinedVideoGenreEntity> genres;
}
