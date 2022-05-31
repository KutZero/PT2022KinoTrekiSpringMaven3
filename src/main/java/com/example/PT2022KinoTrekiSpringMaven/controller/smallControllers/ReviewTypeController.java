package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviewtype")
public class ReviewTypeController {

    @Autowired
    private ReviewTypeRepo reviewTypeRepo;

    @PostMapping
    public ResponseEntity addCreatorRole(@RequestBody ReviewTypeEntity reviewType){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            reviewTypeRepo.save(reviewType);
            return ResponseEntity.ok("Тип отзыва добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления типа отзыва");
        }
    }

    @GetMapping
    ResponseEntity getOneCreatorRole(@RequestParam String name){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(reviewTypeRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения типа отзыва");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCreatorRole(@PathVariable String name){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            ReviewTypeEntity reviewType = reviewTypeRepo.findByName(name);
            reviewTypeRepo.delete(reviewType);
            return ResponseEntity.ok("Типа отзыва удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления типа отзыва");
        }
    }

}
