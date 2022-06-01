package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.ReviewType;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.ReviewTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewTypeService implements SmallService<ReviewTypeEntity, ReviewType, ReviewTypeNotFoundException>{

    @Autowired
    private ReviewTypeRepo reviewTypeRepo;

    @Override
    public ReviewType createEntity(ReviewTypeEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return ReviewType.toModel(reviewTypeRepo.save(entity));
    }

    @Override
    public ReviewType getEntity(Long id) throws ReviewTypeNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!reviewTypeRepo.existsById(id)){
            throw new ReviewTypeNotFoundException("Такого типа отзыва не существует");
        }
        return ReviewType.toModel(reviewTypeRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws ReviewTypeNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!reviewTypeRepo.existsById(id)){
            throw new ReviewTypeNotFoundException("Такого типа отзыва не существует");
        }
        reviewTypeRepo.deleteById(id);
    }
}
