package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.TimeCodeEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.MusicNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.TimeCodeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.AgeRatingNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.TimeCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timecode")
public class TimeCodeController {

    @Autowired
    private TimeCodeService timeCodeService;

    @PostMapping
    public ResponseEntity addTimeCode(@RequestBody TimeCodeEntity timeCode,
                                      @RequestParam Long music_id,
                                      @RequestParam Long user_id,
                                      @RequestParam Long video_id){
        try{
            //ошибки
            // музыки не существует
            // юзера не существует
            // видео не существует
            timeCodeService.addTimeCode(timeCode, music_id, user_id, video_id);
            return ResponseEntity.ok("Тайм-код добавлен");
        }
        catch (MusicNotFoundException | UserNotFoundException | VideoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления тайм-кода");
        }
    }

    @GetMapping
    public ResponseEntity getOneSimpleVideo(@RequestParam Long id){
        try{
            //ошибки
            // такого видео не существует
            //return ResponseEntity.ok(videoService.getSimpleVideoById(id));
            return ResponseEntity.ok(timeCodeService.getSimpleTimeCodeById(id));
        }
        catch (TimeCodeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска тайм-кода");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneRating(@PathVariable Long id){
        try{
            //ошибки
            // такого видео не существует
            //videoService.deleteVideo(id);
            timeCodeService.deleteTimeCode(id);
            return ResponseEntity.ok("Тайм-код удален");
        }
        catch (TimeCodeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления тайм-кода");
        }
    }
}
