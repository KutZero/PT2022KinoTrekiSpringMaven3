package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CreatorNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CreatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepo creatorRepo;

    public CreatorEntity addCreator(CreatorEntity creator){

        return  creatorRepo.save(creator);
    }

    public void deleteCreator(Long id) throws CreatorNotFountExceptioin {
        if (!creatorRepo.existsById(id)){
            throw new CreatorNotFountExceptioin("Создатель не найлен");
        }
        creatorRepo.deleteById(id);
    }

    public CreatorEntity getOneCreator(Long id) throws CreatorNotFountExceptioin {
        if (!creatorRepo.existsById(id)){
            throw new CreatorNotFountExceptioin("Создатель не найлен");
        }
        return creatorRepo.findById(id).get();
    }

}
