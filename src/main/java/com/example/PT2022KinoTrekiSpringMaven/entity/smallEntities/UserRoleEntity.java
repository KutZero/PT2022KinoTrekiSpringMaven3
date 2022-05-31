package com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_role")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user_role",
            cascade = CascadeType.ALL)
    private List<UserEntity> users;
}
