package com.example.PT2022KinoTrekiSpringMaven.service;

import com.example.PT2022KinoTrekiSpringMaven.reposotory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

}
