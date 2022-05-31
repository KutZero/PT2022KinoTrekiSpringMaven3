package com.example.PT2022KinoTrekiSpringMaven.entity;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.UserRoleEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_role_id;
    private String name;
    private String last_name;
    private String add_names;
    private String login;
    private String password;
}
