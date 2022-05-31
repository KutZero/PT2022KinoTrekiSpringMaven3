package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleRepo userRoleRepo;

    @PostMapping
    public ResponseEntity addCreatorRole(@RequestBody UserRoleEntity userRole){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            userRoleRepo.save(userRole);
            return ResponseEntity.ok("Роль юзера добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления роли юзера");
        }
    }

    @GetMapping
    ResponseEntity getOneCreatorRole(@RequestParam String name){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(userRoleRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения роли юзера");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCreatorRole(@PathVariable String name){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            UserRoleEntity userRole = userRoleRepo.findByName(name);
            userRoleRepo.delete(userRole);
            return ResponseEntity.ok("Роль юзера удалена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления роли юзера");
        }
    }
}
