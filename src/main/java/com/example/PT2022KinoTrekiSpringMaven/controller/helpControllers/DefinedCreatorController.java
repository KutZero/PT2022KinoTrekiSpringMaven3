package com.example.PT2022KinoTrekiSpringMaven.controller.helpControllers;

import com.example.PT2022KinoTrekiSpringMaven.exeption.helpExceptions.DefinedCreatorAlreadyExistException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.helpExceptions.DefinedCreatorNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CreatorNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.CreatorRoleNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.service.helpServices.DefinedCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/definedcreator")
public class DefinedCreatorController {

    @Autowired
    private DefinedCreatorService definedCreatorService;

    @PostMapping
    public ResponseEntity addDefCreator(@RequestParam Long video_id,
                                   @RequestParam Long creator_id,
                                   @RequestParam Long creator_role_id){
        try{
            //ошибки
            //

            definedCreatorService.addDefinedCreator(video_id, creator_id, creator_role_id);

            //return ResponseEntity.ok(definedCreatorService.test(video_id, creator_id, creator_role_id));

            //return ResponseEntity.ok(video_id);
            return ResponseEntity.ok("Создатель конкретного видео добавлен");
        }
        catch (VideoNotFountExceptioin | CreatorNotFountExceptioin | CreatorRoleNotFountExceptioin e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления создателя конкретного видео");
        }
    }

    @GetMapping
    public ResponseEntity getOneDefCreator(@RequestParam Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            //videoService.addVideo(video);
            //return ResponseEntity.ok(videoService.getById(id));
            //return ResponseEntity.ok("ok" + id);
            //return ResponseEntity.ok(videoService.getSimpleVideoById(id));
            //return ResponseEntity.ok("Видео получено");
            return ResponseEntity.ok(definedCreatorService.getDefinedCreator(id));
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
            definedCreatorService.deleteDefinedCreator(id);
            return ResponseEntity.ok("Создателя конкретного видео удален");
        }
        catch (DefinedCreatorNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка создателя конкретного видео");
        }
    }
}
