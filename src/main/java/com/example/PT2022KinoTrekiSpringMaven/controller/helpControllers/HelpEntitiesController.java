package com.example.PT2022KinoTrekiSpringMaven.controller.helpControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helpentities")
public class HelpEntitiesController {

    @Autowired
    private AgeRatingRepo ageRatingRepo;

    @Autowired
    private CreatorRoleRepo creatorRoleRepo;

    @Autowired
    private MusicGenreRepo musicGenreRepo;

    @Autowired
    private ReviewTypeRepo reviewTypeRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private VideoGenreRepo videoGenreRepo;

    /*@PostMapping("/agerating")
    public ResponseEntity addRating(@RequestBody AgeRatingEntity ageRating){
        try{
            //ошибки
            // рейтинг уже существует
            // id уже занят
            ageRatingRepo.save(ageRating);
            return ResponseEntity.ok("Возрастной рейтинг добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления возрастного рейтинга");
        }
    }

    @GetMapping("/agerating")
    ResponseEntity getOneRating(@RequestParam Long id){
        try{
            //System.out.println("Подлучить юзера");
            //return ResponseEntity.ok(ageRatingRepo.findByRating(rating));
            //return ResponseEntity.ok("Запись получена");
            //return ResponseEntity.ok(rating);
            //return ResponseEntity.ok(ageRatingRepo.findByRating(rating));
            //return ResponseEntity.ok(ageRatingRepo.findByRating(rating));
            return ResponseEntity.ok(ageRatingRepo.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения рейтинга");
        }
    }

    @DeleteMapping("/agerating/{id}")
    public ResponseEntity deleteRating(@PathVariable Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            // с ним связаны многие записи (не стоит удалять)
            //return ResponseEntity.ok("Удалить рейтинг");
            ageRatingRepo.deleteById(id);
            return ResponseEntity.ok("Рейтинг удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления рейтинга");
        }
    }*/


    /*@PostMapping("/creatorrole")
    public ResponseEntity addCreatorRole(@RequestBody CreatorRoleEntity creatorRole){
        try{
            //ошибки
            // рейтинг уже существует
            // id уже занят
            creatorRoleRepo.save(creatorRole);
            return ResponseEntity.ok("Возрастной рейтинг добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления возрастного рейтинга");
        }
    }

    @GetMapping("/creatorrole")
    ResponseEntity getOneCreatorRole(@RequestParam String name){
        try{
            return ResponseEntity.ok(creatorRoleRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения рейтинга");
        }
    }

    @DeleteMapping("/creatorrole/{id}")
    public ResponseEntity deleteCreatorRole(@PathVariable Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            // с ним связаны многие записи (не стоит удалять)
            //ageRatingRepo.deleteById(id);
            return ResponseEntity.ok("Рейтинг удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления рейтинга");
        }
    }*/

}
