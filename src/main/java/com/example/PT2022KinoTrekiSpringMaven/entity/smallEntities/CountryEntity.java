package com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "country",
            cascade = CascadeType.ALL)
    private List<VideoEntity> videos;
}
