package com.example.PT2022KinoTrekiSpringMaven.controller;

import com.example.PT2022KinoTrekiSpringMaven.entity.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public ResponseEntity addVideo(@RequestBody VideoEntity video,
                                   @RequestParam int age_rating){
        try{
            //ошибки
            // age_rating не существует
            videoService.addVideo(video, age_rating);
            return ResponseEntity.ok("Видео добавлено");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления видео");
        }
    }

    /*@PutMapping
    public ResponseEntity editVideo(@RequestBody VideoEntity video,
                                   @RequestParam Long role_id){
        try{
            //ошибки
            // рейтинг уже существует
            // id уже занят
            videoRepo.save(video);
            return ResponseEntity.ok("Видео добавлено");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления видео");
        }
    }*/

    @GetMapping
    public ResponseEntity getOneVideo(@RequestParam Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            //videoService.addVideo(video);
            //return ResponseEntity.ok(videoService.getById(id));
            //return ResponseEntity.ok("ok" + id);
            //return ResponseEntity.ok(videoService.getById(id));
            return ResponseEntity.ok("Видео получено");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска видео");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneRating(@PathVariable Long id){
        try{
            //ошибки
            // такого видео не существует
            videoService.deleteVideo(id);
            return ResponseEntity.ok("Видео удалено");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления рейтинга");
        }
    }
}
