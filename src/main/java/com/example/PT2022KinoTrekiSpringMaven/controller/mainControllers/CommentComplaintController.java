package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentComplaintEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.CommentComplaintNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.CommentNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.CommentComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentcomplaint")
public class CommentComplaintController {

    @Autowired
    private CommentComplaintService commentComplaintService;

    @PostMapping
    public ResponseEntity addCommentComplaint(@RequestBody CommentComplaintEntity commentComplaint,
                                              @RequestParam Long user_id,
                                              @RequestParam Long comment_id){
        try{
            // ошибки
            // id уже занят
            commentComplaintService.addCommentComplaint(commentComplaint, user_id, comment_id);
            return ResponseEntity.ok("Жалоба на комментарий добавлена");
        }
        catch (UserNotFoundException | CommentNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жалобы на комментарий");
        }
    }

    @GetMapping
    ResponseEntity getOneCommentComplaint(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(commentComplaintService.getCommentComplaintById(id));
        }
        catch (CommentComplaintNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения жалобы на комментарий");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommentComplaint(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            commentComplaintService.deleteCommentComplaint(id);
            return ResponseEntity.ok("Жалоба на комментарий удалена");
        }
        catch (CommentComplaintNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления жалобы на комментарий");
        }
    }
}
