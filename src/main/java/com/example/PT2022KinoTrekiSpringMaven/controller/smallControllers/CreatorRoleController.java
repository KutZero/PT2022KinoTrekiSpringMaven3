package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.CreatorRoleNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.CreatorRoleRepo;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.CreatorRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creatorrole")
public class CreatorRoleController {

    /*@Autowired
    private CreatorRoleRepo creatorRoleRepo;*/

    @Autowired
    private CreatorRoleService creatorRoleService;

    @PostMapping
    public ResponseEntity addCreatorRole(@RequestBody CreatorRoleEntity creatorRole){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            //creatorRoleRepo.save(creatorRole);
            creatorRoleService.createEntity(creatorRole);
            return ResponseEntity.ok("Роль создателя добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления роли создателя");
        }
    }

    @GetMapping
    ResponseEntity getOneCreatorRole(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            //return ResponseEntity.ok(creatorRoleRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
            return ResponseEntity.ok(creatorRoleService.getEntity(id));
        }
        catch (CreatorRoleNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения роли создателя");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCreatorRole(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            /*CreatorRoleEntity creatorRole = creatorRoleRepo.findByName(name);
            creatorRoleRepo.delete(creatorRole);*/
            creatorRoleService.deleteEntity(id);
            return ResponseEntity.ok("Роль создателя удалена");
        }
        catch (CreatorRoleNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления роли создателя");
        }
    }
}
