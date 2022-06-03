package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.AgeRatingNotFoundException;
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
                                   @RequestParam Long rating_id){
        try{
            //ошибки
            // age_rating не существует
            videoService.addVideo(video, rating_id);
            return ResponseEntity.ok("Видео добавлено");
        }
        catch (AgeRatingNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления видео");
        }
    }

    @PutMapping
    public ResponseEntity editVideo(@RequestBody VideoEntity video,
                                    @RequestParam Long rating_id,
                                    @RequestParam Long video_id){
        try{
            //ошибки
            // рейтинг не существует
            // id уже занят
            // видео не существует
            /*videoService.editVideo(video, rating_id, video_id);
            return ResponseEntity.ok("Видео изменено");*/
            return ResponseEntity.ok(videoService.editVideo(video, rating_id, video_id));
        }
        catch (VideoNotFoundException | AgeRatingNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка изменения видео");
        }
    }

    @GetMapping("/simple")
    public ResponseEntity getOneSimpleVideo(@RequestParam Long id){
        try{
            //ошибки
            // такого видео не существует
            return ResponseEntity.ok(videoService.getSimpleVideoById(id));
        }
        catch (VideoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска видео");
        }
    }

    @GetMapping("/extended")
    public ResponseEntity getOneExtendedVideo(@RequestParam Long id){
        try{
            //ошибки
            // такого видео не существует
            return ResponseEntity.ok(videoService.getExtendedVideoById(id));
        }
        catch (VideoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска видео");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneVideo(@PathVariable Long id){
        try{
            //ошибки
            // такого видео не существует
            videoService.deleteVideo(id);
            return ResponseEntity.ok("Видео удалено");
        }
        catch (VideoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления рейтинга");
        }
    }
}
