package com.example.PT2022KinoTrekiSpringMaven.controller.helpControllers;

import com.example.PT2022KinoTrekiSpringMaven.exeption.helpExceptions.DefinedVideoGenreNorFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.VideoGenreNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.service.helpServices.DefinedVideoGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/definedvideogenre")
public class DefinedVideoGenreController {

    @Autowired
    private DefinedVideoGenreService definedVideoGenreService;

    @PostMapping
    public ResponseEntity addDefinedVideoGenre(@RequestParam Long video_id,
                                               @RequestParam Long video_genre_id){
        try{
            //ошибки
            //
            definedVideoGenreService.addDefinedVideoGenre(video_id, video_genre_id);
            return ResponseEntity.ok("Жанр конкретного видео добавлен");
        }
        catch (VideoNotFoundException | VideoGenreNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жанра конкретного видео");
        }
    }

    @GetMapping
    public ResponseEntity getOneDefinedVideoGenre(@RequestParam Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            return ResponseEntity.ok(definedVideoGenreService.getDefinedVideoGenre(id));
        }
        catch (DefinedVideoGenreNorFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска видео");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneDefCreator(@PathVariable Long id){
        try{
            //ошибки
            // такого создателя конкретного видео не существует
            //definedCreatorService.deleteDefinedCreator(id);
            definedVideoGenreService.deleteDefinedVideoGenre(id);
            return ResponseEntity.ok("Создателя конкретного видео удален");
        }
        catch (DefinedVideoGenreNorFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка создателя конкретного видео");
        }
    }
}
