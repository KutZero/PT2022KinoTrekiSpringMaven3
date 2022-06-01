package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CommentRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private UserRepo userRepo;


}
