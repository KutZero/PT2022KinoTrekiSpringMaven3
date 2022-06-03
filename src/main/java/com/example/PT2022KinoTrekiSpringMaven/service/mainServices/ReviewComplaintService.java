package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewComplaintEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.ReviewEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.ReviewComplaintNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.ReviewComplaintModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.ReviewComplaintRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.ReviewRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewComplaintService {

    @Autowired
    private ReviewComplaintRepo reviewComplaintRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewRepo reviewRepo;

    public ReviewComplaintModel addReviewComplaint(ReviewComplaintEntity reviewComplaint, Long user_id, Long review_id) throws UserNotFoundException, ReviewTypeNotFoundException {
        // ошибки
        if (!userRepo.existsById(user_id)){
            throw new UserNotFoundException("Указанный пользователь не существует");
        }

        if(!reviewRepo.existsById(review_id)){
            throw new ReviewTypeNotFoundException("Указанный отзыв не существует");
        }

        ReviewEntity review = reviewRepo.findById(review_id).get();
        UserEntity user = userRepo.findById(user_id).get();

        reviewComplaint.setReview(review);
        reviewComplaint.setUser(user);

        return  ReviewComplaintModel.toModel(reviewComplaintRepo.save(reviewComplaint));
    }

    public void deleteReviewComplaint(Long id) throws ReviewComplaintNotFoundException {
        // ошибки
        if (!reviewComplaintRepo.existsById(id)){
            throw new ReviewComplaintNotFoundException("Указанной жалобы на отзыв не существует");
        }
        reviewComplaintRepo.deleteById(id);
    }

    public ReviewComplaintModel getReviewComplaintById(Long id) throws ReviewComplaintNotFoundException {
        // какая то проверка
        if (!reviewComplaintRepo.existsById(id)){
            throw new ReviewComplaintNotFoundException("Указанной жалобы на отзыв не существует");
        }
        ReviewComplaintEntity reviewComplaint = reviewComplaintRepo.findById(id).get();
        return ReviewComplaintModel.toModel(reviewComplaint);
    }

}
