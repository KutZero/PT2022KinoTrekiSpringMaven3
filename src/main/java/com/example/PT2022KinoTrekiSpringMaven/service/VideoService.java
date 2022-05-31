package com.example.PT2022KinoTrekiSpringMaven.service;

import com.example.PT2022KinoTrekiSpringMaven.entity.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos.AgeRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private AgeRatingRepo ratingRepo;

    public VideoEntity addVideo(VideoEntity video, int age_rating){
        // ошибки
        // нет такого возрастнного рейтинга
        AgeRatingEntity ageRating = ratingRepo.findByRating(age_rating);
        video.setRating(ageRating);
        return videoRepo.save(video);
    }

    public void deleteVideo(Long id){
        // ошибки
        // есть ли такое видео
        videoRepo.deleteById(id);
    }

    /*public VideoEntity getById(Long id){
        // какая то проверка
        //System.out.println(id);
        //VideoEntity video = new VideoEntity(); //videoRepo.findById(id).get();
        return video;
    }*/
}
