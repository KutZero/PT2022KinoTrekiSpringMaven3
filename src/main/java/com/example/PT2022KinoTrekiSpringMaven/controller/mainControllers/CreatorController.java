package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;


import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    private CreatorService creatorService;

    @PostMapping
    public ResponseEntity addCreator(@RequestBody CreatorEntity creator){
        try{
            // ошибки
            // такая сущность уже существует
            // id уже занят
            //creatorRoleRepo.save(creatorRole);
            creatorService.addCreator(creator);
            return ResponseEntity.ok("Создатель добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления создателя");
        }
    }

    @GetMapping
    ResponseEntity getOneCreator(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            //return ResponseEntity.ok(creatorRoleRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
            return ResponseEntity.ok(creatorService.getOneCreator(id));
            //return ResponseEntity.ok("НАЙТИ СОЗДАТЕЛЯ");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения создателя");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCreator(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            //CreatorRoleEntity creatorRole = creatorRoleRepo.findByName(name);
            //creatorRoleRepo.delete(creatorRole);
            creatorService.deleteCreator(id);
            return ResponseEntity.ok("Роль создателя удалена");
            //return ResponseEntity.ok("УДАЛИТЬ СОЗДАТЕЛЯ");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления создателя");
        }
    }
}
