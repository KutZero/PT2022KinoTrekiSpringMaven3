package com.example.PT2022KinoTrekiSpringMaven.controller;

import com.example.PT2022KinoTrekiSpringMaven.entity.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.UserAlreadyExistException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity singUp(@RequestBody UserEntity user){
        try{
            System.out.println("Зарегестрировать юзера");
            //userService.singUp(user);
            return ResponseEntity.ok("Пользователь зарегестрирован");
        }
        /*catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка регистрации!");
        }
    }

    @GetMapping
    ResponseEntity getOneUser(@RequestParam Long id){
        try{
            System.out.println("Подлучить юзера");
            //return ResponseEntity.ok(userService.getOne(id));
        }
        /*catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }*/
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка на сервера!");
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            System.out.println("Удалить юзера");
            //return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка на сервера!");
        }
        return null;
    }


}
