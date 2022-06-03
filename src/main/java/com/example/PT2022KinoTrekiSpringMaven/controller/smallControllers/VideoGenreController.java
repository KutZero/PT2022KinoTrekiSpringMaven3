package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.VideoGenreNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.VideoGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videogenre")
public class VideoGenreController {

    @Autowired
    private VideoGenreService videoGenreService;

    @PostMapping
    public ResponseEntity addVideoGenre(@RequestBody VideoGenreEntity videoGenre){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            videoGenreService.createEntity(videoGenre);
            return ResponseEntity.ok("Жанр фильма добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жанра фильма");
        }
    }

    @GetMapping
    ResponseEntity getOneVideoGenre(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(videoGenreService.getEntity(id));
        }
        catch (VideoGenreNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения жанра фильма");
        }
    }

    @GetMapping("/all")
    ResponseEntity getAllVideoGenres(){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(videoGenreService.getAllEntities());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения списка жанров фильмов");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVideoGenre(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            videoGenreService.deleteEntity(id);
            return ResponseEntity.ok("Жанр фильма удален");
        }
        catch (VideoGenreNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления жанра фильма");
        }
    }
}
