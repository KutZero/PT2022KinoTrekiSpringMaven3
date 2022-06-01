package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.*;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CommentComplaintNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CommentNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.ReviewComplaintNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.CommentComplaintModel;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.ReviewComplaintModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CommentComplaintRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CommentRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentComplaintService {

    @Autowired
    private CommentComplaintRepo commentComplaintRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CommentRepo commentRepo;

    public CommentComplaintModel addCommentComplaint(CommentComplaintEntity commentComplaint, Long user_id, Long comment_id) throws UserNotFoundException, CommentNotFoundException {
        // ошибки
        if (!userRepo.existsById(user_id)){
            throw new UserNotFoundException("Указанный пользователь не существует");
        }

        if (!commentRepo.existsById(comment_id)){
            throw new CommentNotFoundException("Указанный комментарий не сущестсвует");
        }

        CommentEntity comment = commentRepo.findById(comment_id).get();
        UserEntity user = userRepo.findById(user_id).get();

        commentComplaint.setComment(comment);
        commentComplaint.setUser(user);

        return  CommentComplaintModel.toModel(commentComplaintRepo.save(commentComplaint));
    }

    public void deleteCommentComplaint(Long id) throws CommentComplaintNotFoundException {
        // ошибки
        if (!commentComplaintRepo.existsById(id)){
            throw new CommentComplaintNotFoundException("Указанной жалобы на комментарий не существует");
        }
        commentComplaintRepo.deleteById(id);
    }

    public CommentComplaintModel getCommentComplaintById(Long id) throws CommentComplaintNotFoundException {
        // какая то проверка
        if (!commentComplaintRepo.existsById(id)){
            throw new CommentComplaintNotFoundException("Указанной жалобы на комментарий не существует");
        }
        CommentComplaintEntity commentComplaint = commentComplaintRepo.findById(id).get();
        return CommentComplaintModel.toModel(commentComplaint);
    }
}
