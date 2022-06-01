package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.UserRoleNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.UserRole;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements SmallService<UserRoleEntity, UserRole, UserRoleNotFoundException>{

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Override
    public UserRole createEntity(UserRoleEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return UserRole.toModel(userRoleRepo.save(entity));
    }

    @Override
    public UserRole getEntity(Long id) throws UserRoleNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!userRoleRepo.existsById(id)){
            throw new UserRoleNotFoundException("Такой роли пользователя не существует");
        }
        return UserRole.toModel(userRoleRepo.findById(id).get());
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
