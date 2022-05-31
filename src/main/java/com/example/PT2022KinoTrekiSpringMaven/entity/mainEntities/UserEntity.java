package com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long user_role_id;
    private String name;
    private String last_name;
    private String add_names;
    private String login;
    private String password;

    @ManyToOne
    @JoinColumn (name="user_role_id")
    private UserRoleEntity user_role;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL)
    private List<ReviewComplaintEntity> review_complaints;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL)
    private List<CommentComplaintEntity> comment_complaints;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<TimeCodeEntity> time_codes;

}
