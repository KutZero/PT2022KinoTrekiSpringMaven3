package com.example.PT2022KinoTrekiSpringMaven.controller.mainControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewComplaintEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CommentNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.ReviewComplaintNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.mainServices.ReviewComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviewcomplaint")
public class ReviewComplaintController {

    @Autowired
    private ReviewComplaintService reviewComplaintService;

    @PostMapping
    public ResponseEntity addReviewComplaint(@RequestBody ReviewComplaintEntity reviewComplaint,
                                             @RequestParam Long user_id,
                                             @RequestParam Long review_id){
        try{
            // ошибки
            // id уже занят
            reviewComplaintService.addReviewComplaint(reviewComplaint, user_id, review_id);
            return ResponseEntity.ok("Жалоба на отзыв добавлена");
        }
        catch (UserNotFoundException | ReviewTypeNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления жалобы на отзыв");
        }
    }

    @GetMapping
    ResponseEntity getOneReviewComplaint(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(reviewComplaintService.getReviewComplaintById(id));
        }
        catch (ReviewComplaintNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения жалобы на отзыв");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneReviewComplaint(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            reviewComplaintService.deleteReviewComplaint(id);
            return ResponseEntity.ok("Жалобы на отзыв удалена");
        }
        catch (ReviewComplaintNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления жалобы на отзыв");
        }
    }
}
