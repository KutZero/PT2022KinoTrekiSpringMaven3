package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.*;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity addReview(@RequestBody ReviewEntity review,
                                      @RequestParam Long video_id,
                                      @RequestParam Long user_id,
                                      @RequestParam Long review_type_id){
        try{
            //ошибки
            // юзера не существует
            // видео не существует
            reviewService.addReview(review,video_id, user_id, review_type_id);
            return ResponseEntity.ok("Отзыв добавлен");
        }
        catch (UserNotFoundException | VideoNotFoundException | ReviewTypeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления отзыва");
        }
    }

    @GetMapping
    public ResponseEntity getOneReview(@RequestParam Long id){
        try{
            //ошибки
            // такого видео не существует
            return ResponseEntity.ok(reviewService.getReviewById(id));
        }
        catch (ReviewNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка поиска отзыва");
        }
    }

    @PutMapping
    public ResponseEntity editCommentState(@RequestParam Long id,
                                           @RequestParam boolean state){
        try{
            //ошибки
            // рейтинг не существует
            // id уже занят
            // видео не существует
            reviewService.setReviewVisibleState(id, state);
            return ResponseEntity.ok("Видимость отзыва изменено на: " + state);
        }
        catch (ReviewNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка изменения видимости отзыва");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneReview(@PathVariable Long id){
        try{
            //ошибки
            // такого видео не существует
            reviewService.deleteReview(id);
            return ResponseEntity.ok("Отзыв удален");
        }
        catch (ReviewNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления отзыва");
        }
    }
}
