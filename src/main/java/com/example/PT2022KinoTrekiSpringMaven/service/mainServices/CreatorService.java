package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.mainRepos.CreatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepo creatorRepo;

    public CreatorEntity addCreator(CreatorEntity creator){
        return  creatorRepo.save(creator);
    }

    public void deleteCreator(Long id){
        creatorRepo.deleteById(id);
    }

    public CreatorEntity getOneCreator(Long id){
        return creatorRepo.findById(id).get();
    }

}
