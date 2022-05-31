package com.example.PT2022KinoTrekiSpringMaven.service;

import com.example.PT2022KinoTrekiSpringMaven.entity.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.model.SimpleVideo;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos.AgeRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public SimpleVideo getSimpleVideoById(Long id){
        // какая то проверка
        //System.out.println(id);
        //VideoEntity video = new VideoEntity(); //videoRepo.findById(id).get();
        VideoEntity video = videoRepo.findById(id).get();
        return SimpleVideo.toModel(video);
    }
}
