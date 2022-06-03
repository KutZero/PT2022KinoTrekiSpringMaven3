package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.ReviewTypeModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.ReviewTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewTypeService implements SmallService<ReviewTypeEntity, ReviewTypeModel, ReviewTypeNotFoundException>{

    @Autowired
    private ReviewTypeRepo reviewTypeRepo;

    @Override
    public ReviewTypeModel createEntity(ReviewTypeEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return ReviewTypeModel.toModel(reviewTypeRepo.save(entity));
    }

    @Override
    public ReviewTypeModel getEntity(Long id) throws ReviewTypeNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!reviewTypeRepo.existsById(id)){
            throw new ReviewTypeNotFoundException("Такого типа отзыва не существует");
        }
        return ReviewTypeModel.toModel(reviewTypeRepo.findById(id).get());
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
