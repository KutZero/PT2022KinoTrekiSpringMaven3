package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.AgeRatingNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.AgeRatingModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.AgeRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeRatingService implements SmallService<AgeRatingEntity, AgeRatingModel, AgeRatingNotFoundException> {

    @Autowired
    private AgeRatingRepo ageRatingRepo;

    @Override
    public AgeRatingModel createEntity(AgeRatingEntity ageRating) {
        // Ошибки
        // Уже существует такая сущность
        return AgeRatingModel.toModel(ageRatingRepo.save(ageRating));
    }

    @Override
    public AgeRatingModel getEntity(Long id) throws AgeRatingNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!ageRatingRepo.existsById(id)){
            throw new AgeRatingNotFoundException("Такого рейтинга не существует");
        }
        return AgeRatingModel.toModel(ageRatingRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws AgeRatingNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!ageRatingRepo.existsById(id)){
            throw new AgeRatingNotFoundException("Такого рейтинга не существует");
        }
        ageRatingRepo.deleteById(id);
    }


}
