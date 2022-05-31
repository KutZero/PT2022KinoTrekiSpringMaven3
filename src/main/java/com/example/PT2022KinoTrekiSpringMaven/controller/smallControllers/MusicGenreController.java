package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos.MusicGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicgenre")
public class MusicGenreController {
    @Autowired
    private MusicGenreRepo musicGenreRepo;

    @PostMapping
    public ResponseEntity addCreatorRole(@RequestBody MusicGenreEntity musicGenre){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            musicGenreRepo.save(musicGenre);
            return ResponseEntity.ok("Жанр музыки добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жанра музыки");
        }
    }

    @GetMapping
    ResponseEntity getOneCreatorRole(@RequestParam String name){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(musicGenreRepo.findByName(name));
            //return ResponseEntity.ok("Запись получена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения жанра музыки");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteCreatorRole(@PathVariable String name){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            MusicGenreEntity creatorRole = musicGenreRepo.findByName(name);
            musicGenreRepo.delete(creatorRole);
            return ResponseEntity.ok("Жанр музыки удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления жанра музыки");
        }
    }
}
