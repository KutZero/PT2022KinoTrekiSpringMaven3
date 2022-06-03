package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.MusicEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.MusicNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping
    public ResponseEntity addMusic(@RequestBody MusicEntity music,
                                   @RequestParam Long music_genre_id){
        try{
            // ошибки
            // id уже занят
            //creatorService.addCreator(creator);
            musicService.addMusic(music, music_genre_id);
            return ResponseEntity.ok("Песня добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления песни");
        }
    }


    @GetMapping
    ResponseEntity getOneMusic(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            //return ResponseEntity.ok(creatorService.getOneCreator(id));
            return ResponseEntity.ok(musicService.getOneSimpleMusicById(id));
        }
        catch (MusicNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения песни");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneMusic(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            //creatorService.deleteCreator(id);
            musicService.deleteMusic(id);
            return ResponseEntity.ok("Песня удалена");
        }
        catch (MusicNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления песни");
        }
    }
}
