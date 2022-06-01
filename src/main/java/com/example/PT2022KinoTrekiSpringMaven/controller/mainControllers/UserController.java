package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.UserRoleNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity singUpUser(@RequestBody UserEntity user,
                                   @RequestParam Long user_role_id){
        try{
            //ошибки
            // user_role_id не существует
            userService.singUpUser(user, user_role_id);
            return ResponseEntity.ok("Пользователь добавлен");
        }
        catch (UserRoleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления пользователя");
        }
    }

    @GetMapping
    public ResponseEntity getOneSimpleUser(@RequestParam Long id){
        try{
            //ошибки
            // такого видео не существует
            return ResponseEntity.ok(userService.getOneSimpleUserById(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска пользователя");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneRating(@PathVariable Long id){
        try{
            //ошибки
            // такого видео не существует
            userService.deleteUser(id);
            return ResponseEntity.ok("Пользователь удален");
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления пользователя");
        }
    }
}
