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
    private String name;
    @JoinColumn(name = "last_name")
    private String lastName;
    @JoinColumn(name = "add_names")
    private String addNames;
    private String login;
    private String password;
    @JoinColumn(name = "photo_path")
    private String photoPath;

    @ManyToOne
    @JoinColumn (name="user_role_id")
    private UserRoleEntity userRole;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL)
    private List<ReviewComplaintEntity> reviewComplaints;

    @OneToMany(fetch = FetchType.LAZY,
        mappedBy = "user",
        cascade = CascadeType.ALL)
    private List<CommentComplaintEntity> commentComplaints;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<TimeCodeEntity> timeCodes;

}
