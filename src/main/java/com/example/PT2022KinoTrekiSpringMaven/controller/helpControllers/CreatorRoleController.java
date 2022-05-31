package com.example.PT2022KinoTrekiSpringMaven.controller.helpControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos.CreatorRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatorrole")
public class CreatorRoleController {

    @Autowired
    private CreatorRoleRepo creatorRoleRepo;

    @PostMapping
    public ResponseEntity addCreatorRole(@RequestBody CreatorRoleEntity creatorRole){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            creatorRoleRepo.save(creatorRole);
            return ResponseEntity.ok("Роль создателя добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления роли создателя");
        }
    }

    @GetMapping
    ResponseEntity getOneCreatorRole(@RequestParam String name){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(creatorRoleRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения роли создателя");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCreatorRole(@PathVariable String name){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            CreatorRoleEntity creatorRole = creatorRoleRepo.findByName(name);
            creatorRoleRepo.delete(creatorRole);
            return ResponseEntity.ok("Роль создателя удалена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления роли создателя");
        }
    }
}
