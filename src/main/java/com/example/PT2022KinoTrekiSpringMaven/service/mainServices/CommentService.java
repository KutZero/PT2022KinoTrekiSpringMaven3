package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CommentEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CommentNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.CommentModel;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.SimpleUserModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CommentRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private UserRepo userRepo;

    public CommentModel addComment(CommentEntity comment, Long video_id, Long user_id) throws UserNotFoundException, VideoNotFoundException {
        // ошибки
        // нет такого пользователя
        // нет такого видео
        if (!userRepo.existsById(user_id)){
            throw new UserNotFoundException("Указанный пользователь не существует");
        }

        if (!videoRepo.existsById(video_id)){
            throw new VideoNotFoundException("Указанное видео не существует");
        }

        VideoEntity video = videoRepo.findById(video_id).get();
        UserEntity user = userRepo.findById(user_id).get();

        comment.setVideo(video);
        comment.setUser(user);

        return CommentModel.toModel(commentRepo.save(comment));
    }

    public void deleteComment(Long id) throws UserNotFoundException, CommentNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!commentRepo.existsById(id)){
            throw new CommentNotFoundException("Указанного комментария не существует");
        }
        commentRepo.deleteById(id);
    }

    public void setCommentVisibleState(Long id, boolean state) throws UserNotFoundException, CommentNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!commentRepo.existsById(id)){
            throw new CommentNotFoundException("Указанного комментария не существует");
        }
        CommentEntity comment = commentRepo.findById(id).get();
        comment.setOutput_state(state);
    }

    public CommentModel getOneSimpleCommentById(Long id) throws CommentNotFoundException {
        // какая то проверка
        if (!commentRepo.existsById(id)){
            throw new CommentNotFoundException("Указанного комментария не существует");
        }
        CommentEntity comment = commentRepo.findById(id).get();
        return CommentModel.toModel(comment);
    }

}
