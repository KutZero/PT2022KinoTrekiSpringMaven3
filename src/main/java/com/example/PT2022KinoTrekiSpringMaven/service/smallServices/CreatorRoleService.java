package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.CreatorRoleNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CreatorRoleModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.CreatorRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatorRoleService implements SmallService<CreatorRoleEntity, CreatorRoleModel, CreatorRoleNotFountExceptioin>{

    @Autowired
    private CreatorRoleRepo creatorRoleRepo;

    @Override
    public CreatorRoleModel createEntity(CreatorRoleEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return CreatorRoleModel.toModel(creatorRoleRepo.save(entity));
    }

    @Override
    public CreatorRoleModel getEntity(Long id) throws CreatorRoleNotFountExceptioin {
        // Ошибки
        // Такая сущность не существует
        if (!creatorRoleRepo.existsById(id)){
            throw new CreatorRoleNotFountExceptioin("Такой роли создателя не существует");
        }
        return CreatorRoleModel.toModel(creatorRoleRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws CreatorRoleNotFountExceptioin {
        // Ошибки
        // Такая сущность не существует
        if (!creatorRoleRepo.existsById(id)){
            throw new CreatorRoleNotFountExceptioin("Такой роли создателя не существует");
        }
        creatorRoleRepo.deleteById(id);
    }

    @Override
    public List<CreatorRoleModel> getAllEntities() {
        return creatorRoleRepo.findAll().stream().map(CreatorRoleModel::toModel).collect(Collectors.toList());
    }
}
