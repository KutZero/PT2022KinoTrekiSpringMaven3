package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.UserRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.UserRoleNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity addUserRole(@RequestBody UserRoleEntity userRole){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            userRoleService.createEntity(userRole);
            return ResponseEntity.ok("Роль юзера добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления роли юзера");
        }
    }

    @GetMapping
    ResponseEntity getOneUserRole(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(userRoleService.getEntity(id));
        }
        catch (UserRoleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения роли юзера");
        }
    }

    @GetMapping("/all")
    ResponseEntity getAllVideoGenres(){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(userRoleService.getAllEntities());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения списка ролей юзеров");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserRole(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            userRoleService.deleteEntity(id);
            return ResponseEntity.ok("Роль юзера удалена");
        }
        catch (UserRoleNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления роли юзера");
        }
    }
}
