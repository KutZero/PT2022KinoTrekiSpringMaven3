package com.example.PT2022KinoTrekiSpringMaven.controller.helpControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.service.helpServices.DefinedCreatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/definedcreator")
public class DefinedCreatorController {

    private DefinedCreatorService definedCreatorService;

    @PostMapping
    public ResponseEntity addVideo(@RequestBody DefinedCreatorEntity definedCreator,
                                   @RequestParam Long video_id,
                                   @RequestParam Long creator_id,
                                   @RequestParam Long creator_role_id){
        try{
            //ошибки
            //
            definedCreatorService.addDefinedCreator(definedCreator, video_id, creator_id, creator_role_id);
            return ResponseEntity.ok("Создатель конкретного видео добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления создателя конкретного видео");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneRating(@PathVariable Long id){
        try{
            //ошибки
            // такого создателя конкретного видео не существует
            definedCreatorService.deleteDefinedCreator(id);
            return ResponseEntity.ok("Создателя конкретного видео удален");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка создателя конкретного видео");
        }
    }
}
