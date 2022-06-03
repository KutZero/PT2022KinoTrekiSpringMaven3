package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.UserRoleNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.UserRoleModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements SmallService<UserRoleEntity, UserRoleModel, UserRoleNotFoundException>{

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Override
    public UserRoleModel createEntity(UserRoleEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return UserRoleModel.toModel(userRoleRepo.save(entity));
    }

    @Override
    public UserRoleModel getEntity(Long id) throws UserRoleNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!userRoleRepo.existsById(id)){
            throw new UserRoleNotFoundException("Такой роли пользователя не существует");
        }
        return UserRoleModel.toModel(userRoleRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws UserRoleNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!userRoleRepo.existsById(id)){
            throw new UserRoleNotFoundException("Такой роли пользователя не существует");
        }
        userRoleRepo.deleteById(id);
    }
}
