package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos.AgeRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ageraiting")
public class AgeRaitingController {

    @Autowired
    private AgeRatingRepo ageRatingRepo;

    @PostMapping
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

    @GetMapping
    ResponseEntity getOneRating(@RequestParam int rating){
        try{
            //ошибки
            // такого рейтинга не существует
            return ResponseEntity.ok(ageRatingRepo.findByRating(rating));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения рейтинга");
        }
    }

    @DeleteMapping("/{rating}")
    public ResponseEntity deleteOneRating(@PathVariable int rating){
        try{
            //ошибки
            // такого рейтинга не существует
            // с ним связаны многие записи (не стоит удалять)
            //ageRatingRepo.deleteById(id);
            AgeRatingEntity ageRating = ageRatingRepo.findByRating(rating); //Костыль
            ageRatingRepo.delete(ageRating);
            return ResponseEntity.ok("Рейтинг удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления рейтинга");
        }
    }
}
