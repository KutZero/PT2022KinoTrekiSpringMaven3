package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.VideoGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videogenre")
public class VideoGenreController {

    @Autowired
    private VideoGenreRepo videoGenreRepo;

    @PostMapping
    public ResponseEntity addCreatorRole(@RequestBody VideoGenreEntity videoGenre){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            videoGenreRepo.save(videoGenre);
            return ResponseEntity.ok("Жанр фильма добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жанра фильма");
        }
    }

    @GetMapping
    ResponseEntity getOneCreatorRole(@RequestParam String name){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(videoGenreRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения жанра фильма");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCreatorRole(@PathVariable String name){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            VideoGenreEntity videoGenre = videoGenreRepo.findByName(name);
            videoGenreRepo.delete(videoGenre);
            return ResponseEntity.ok("Жанр фильма удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления жанра фильма");
        }
    }
}
