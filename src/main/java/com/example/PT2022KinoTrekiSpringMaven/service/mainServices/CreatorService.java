package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CreatorNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.Creator;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CreatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepo creatorRepo;

    public Creator addCreator(CreatorEntity creator){
        return   Creator.toModel(creatorRepo.save(creator));
    }

    public void deleteCreator(Long id) throws CreatorNotFountExceptioin {
        if (!creatorRepo.existsById(id)){
            throw new CreatorNotFountExceptioin("Создатель не найлен");
        }
        creatorRepo.deleteById(id);
    }

    public Creator getOneCreator(Long id) throws CreatorNotFountExceptioin {
        if (!creatorRepo.existsById(id)){
            throw new CreatorNotFountExceptioin("Создатель не найлен");
        }
        return  Creator.toModel(creatorRepo.findById(id).get());
    }

}
