package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.AgeRatingNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.AgeRatingRepo;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.AgeRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ageraiting")
public class AgeRaitingController {

    @Autowired
    private AgeRatingService ageRatingService;

    @PostMapping
    public ResponseEntity addRating(@RequestBody AgeRatingEntity ageRating){
        try{
            //ошибки
            // рейтинг уже существует
            // id уже занят
            ageRatingService.createEntity(ageRating);
            return ResponseEntity.ok("Возрастной рейтинг добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления возрастного рейтинга");
        }
    }

    @GetMapping
    ResponseEntity getOneRating(@RequestParam Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            return ResponseEntity.ok(ageRatingService.getEntity(id));
        }
        catch (AgeRatingNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения рейтинга");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneRating(@PathVariable Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            // с ним связаны многие записи (не стоит удалять)
            ageRatingService.deleteEntity(id);
            return ResponseEntity.ok("Рейтинг удален");
        }
        catch (AgeRatingNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления рейтинга");
        }
    }
}
