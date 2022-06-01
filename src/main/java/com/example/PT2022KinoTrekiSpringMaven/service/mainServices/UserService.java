package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.UserRoleNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.SimpleUser;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    public SimpleUser singUpUser(UserEntity user, Long user_role_id) throws UserRoleNotFoundException {
        // ошибки
        // нет такого возрастнного рейтинга
        if (!userRoleRepo.existsById(user_role_id)){
            throw new UserRoleNotFoundException("Указанная роль пользователя не существует");
        }

        UserRoleEntity userRole = userRoleRepo.findById(user_role_id).get();
        user.setUser_role(userRole);
        return SimpleUser.toModel(userRepo.save(user));
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!userRepo.existsById(id)){
            throw new UserNotFoundException("Указанного пользователя не существует");
        }
        userRepo.deleteById(id);
    }

    public SimpleUser getOneSimpleUserById(Long id) throws UserNotFoundException {
        // какая то проверка
        if (!userRepo.existsById(id)){
            throw new UserNotFoundException("Указанного пользователя не существует");
        }
        UserEntity user = userRepo.findById(id).get();
        return SimpleUser.toModel(user);
    }

}
