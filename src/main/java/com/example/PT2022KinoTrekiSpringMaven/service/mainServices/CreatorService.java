package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.CreatorNotFountException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.CreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CreatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepo creatorRepo;

    public CreatorModel addCreator(CreatorEntity creator){
        return CreatorModel.toModel(creatorRepo.save(creator));
    }

    public void deleteCreator(Long id) throws CreatorNotFountException {
        if (!creatorRepo.existsById(id)){
            throw new CreatorNotFountException("Создатель не найлен");
        }
        creatorRepo.deleteById(id);
    }

    public CreatorModel getOneCreator(Long id) throws CreatorNotFountException {
        if (!creatorRepo.existsById(id)){
            throw new CreatorNotFountException("Создатель не найлен");
        }
        return CreatorModel.toModel(creatorRepo.findById(id).get());
    }

}
