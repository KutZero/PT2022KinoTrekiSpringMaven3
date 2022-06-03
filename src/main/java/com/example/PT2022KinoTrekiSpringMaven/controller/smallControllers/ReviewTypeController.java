package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.ReviewTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviewtype")
public class ReviewTypeController {

    @Autowired
    private ReviewTypeService reviewTypeService;

    @PostMapping
    public ResponseEntity addReviewType(@RequestBody ReviewTypeEntity entity){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            reviewTypeService.createEntity(entity);
            return ResponseEntity.ok("Тип отзыва добавлен");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления типа отзыва");
        }
    }

    @GetMapping
    ResponseEntity getOneReviewType(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(reviewTypeService.getEntity(id));
        }
        catch (ReviewTypeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения типа отзыва");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReviewType(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            reviewTypeService.deleteEntity(id);
            return ResponseEntity.ok("Тип отзыва удален");
        }
        catch (ReviewTypeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления типа отзыва");
        }
    }
}
