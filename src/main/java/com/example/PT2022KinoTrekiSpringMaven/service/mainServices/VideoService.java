package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.SimpleVideo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.AgeRatingRepo;
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

    public SimpleVideo editVideo(VideoEntity video, int age_rating, Long video_id) throws VideoNotFountExceptioin {
        // ошибки
        // есть ли такое видео
        // нет такого возрастнного рейтинга
        VideoEntity videoEntity = videoRepo.findById(video_id).get();
        if (videoEntity == null){
            throw new VideoNotFountExceptioin("Видео не найдено");
        }

        if (age_rating != videoEntity.getRating().getRating()) {
            AgeRatingEntity ageRating = ratingRepo.findByRating(age_rating);
            videoEntity.setRating(ageRating);
        }

        videoEntity.setComments(video.getComments());
        videoEntity.setAdd_date(video.getAdd_date());
        videoEntity.setDef_creators(video.getDef_creators());
        videoEntity.setDescription(video.getDescription());
        videoEntity.setDuration(video.getDuration());
        videoEntity.setName(video.getName());
        videoEntity.setTrailer_link(video.getTrailer_link());
        videoEntity.setTime_codes(video.getTime_codes());
        videoEntity.setReviews(video.getReviews());
        videoEntity.setDef_genres(video.getDef_genres());
        videoEntity.setPoster_path(video.getPoster_path());
        videoEntity.setRelease_year(video.getRelease_year());
        videoEntity.setTagline(video.getTagline());

        return SimpleVideo.toModel(videoRepo.save(videoEntity));
    }

    public SimpleVideo getSimpleVideoById(Long id){
        // какая то проверка
        //System.out.println(id);
        //VideoEntity video = new VideoEntity(); //videoRepo.findById(id).get();
        VideoEntity video = videoRepo.findById(id).get();
        return SimpleVideo.toModel(video);
    }
}
