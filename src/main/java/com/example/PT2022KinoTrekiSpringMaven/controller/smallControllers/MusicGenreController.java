package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.MusicGenreNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.MusicGenreRepo;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.MusicGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicgenre")
public class MusicGenreController {

    /*@Autowired
    private MusicGenreRepo musicGenreRepo;*/

    @Autowired
    private MusicGenreService musicGenreService;

    @PostMapping
    public ResponseEntity addMusicGenre(@RequestBody MusicGenreEntity musicGenre){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            musicGenreService.createEntity(musicGenre);
            return ResponseEntity.ok("Жанр музыки добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жанра музыки");
        }
    }

    @GetMapping
    ResponseEntity getOneMusicGenre(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(musicGenreService.getEntity(id));
        }
        catch (MusicGenreNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения жанра музыки");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusicGenre(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            musicGenreService.deleteEntity(id);
            return ResponseEntity.ok("Жанр музыки удален");
        }
        catch (MusicGenreNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления жанра музыки");
        }
    }
}
