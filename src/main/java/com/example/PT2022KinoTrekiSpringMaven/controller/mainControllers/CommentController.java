package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CommentNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.AgeRatingNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentEntity comment,
                                     @RequestParam Long video_id,
                                     @RequestParam Long user_id){
        try{
            // ошибки
            // id уже занят
            commentService.addComment(comment, video_id, user_id);
            return ResponseEntity.ok("Комментарий добавлен");
        }
        catch (UserNotFoundException | VideoNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления комментария");
        }
    }

    @GetMapping
    ResponseEntity getOneComment(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(commentService.getOneSimpleCommentById(id));
        }
        catch (CommentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения комментария");
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
            commentService.setCommentVisibleState(id, state);
            return ResponseEntity.ok("Видимость комментария изменено на: " + state);
        }
        catch (CommentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка изменения видимости комментария");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            commentService.deleteComment(id);
            return ResponseEntity.ok("Комментарий удален");
        }
        catch (CommentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления комментария");
        }
    }
}
