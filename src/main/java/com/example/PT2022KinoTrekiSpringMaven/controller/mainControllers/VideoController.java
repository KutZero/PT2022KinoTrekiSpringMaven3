package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.VideoService;
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

    @PutMapping
    public ResponseEntity editVideo(@RequestBody VideoEntity video,
                                    @RequestParam int age_rating,
                                    @RequestParam Long video_id){
        try{
            //ошибки
            // рейтинг не существует
            // id уже занят
            // видео не существует
            videoService.editVideo(video, age_rating, video_id);
            return ResponseEntity.ok("Видео изменено");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка изменения видео");
        }
    }

    @GetMapping
    public ResponseEntity getOneSimpleVideo(@RequestParam Long id){
        try{
            //ошибки
            // такого рейтинга не существует
            //videoService.addVideo(video);
            //return ResponseEntity.ok(videoService.getById(id));
            //return ResponseEntity.ok("ok" + id);
            return ResponseEntity.ok(videoService.getSimpleVideoById(id));
            //return ResponseEntity.ok("Видео получено");
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
