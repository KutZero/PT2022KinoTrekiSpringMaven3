package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CreatorNotFountExceptioin;
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
            // id уже занят
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
            return ResponseEntity.ok(creatorService.getOneCreator(id));
        }
        catch (CreatorNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
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
            creatorService.deleteCreator(id);
            return ResponseEntity.ok("Роль создателя удалена");
        }
        catch (CreatorNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления создателя");
        }
    }
}
