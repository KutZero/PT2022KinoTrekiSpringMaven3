package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.*;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.*;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.ReviewModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.ReviewRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.ReviewTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewTypeRepo reviewTypeRepo;

    public ReviewModel addReview(ReviewEntity review, Long video_id, Long user_id, Long review_type_id) throws UserNotFoundException, VideoNotFoundException, ReviewTypeNotFoundException {
        // ошибки
        // нет такого возрастнного рейтинга

        if (!userRepo.existsById(user_id)){
            throw new UserNotFoundException("Указанный пользователь не существует");
        }

        if (!videoRepo.existsById(video_id)){
            throw new VideoNotFoundException("Указанное видео не существует");
        }

        if(!reviewTypeRepo.existsById(review_type_id)){
            throw new ReviewTypeNotFoundException("Указанный тип отзыва не существует");
        }

        ReviewTypeEntity reviewType = reviewTypeRepo.findById(review_type_id).get();
        UserEntity user = userRepo.findById(user_id).get();
        VideoEntity video = videoRepo.findById(video_id).get();

        review.setReview_type(reviewType);
        review.setUser(user);
        review.setVideo(video);

        return  ReviewModel.toModel(reviewRepo.save(review));
    }

    public void setReviewVisibleState(Long id, boolean state) throws ReviewNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!reviewRepo.existsById(id)){
            throw new ReviewNotFoundException("Указанного отзыва не существует");
        }
        ReviewEntity review = reviewRepo.findById(id).get();
        review.setOutput_state(state);
    }

    public void deleteReview(Long id) throws ReviewNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!reviewRepo.existsById(id)){
            throw new ReviewNotFoundException("Указанного отзыва не существует");
        }
        reviewRepo.deleteById(id);
    }

    public ReviewModel getReviewById(Long id) throws ReviewNotFoundException {
        // какая то проверка
        //System.out.println(id);
        //VideoEntity video = new VideoEntity(); //videoRepo.findById(id).get();
        if (!reviewRepo.existsById(id)){
            throw new ReviewNotFoundException("Указанного отзыва не существует");
        }
        ReviewEntity review = reviewRepo.findById(id).get();
        return ReviewModel.toModel(review);
    }


}
