package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.AgeRatingNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.ExtendedVideoModel;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.SimpleVideoModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.AgeRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private AgeRatingRepo ratingRepo;

    public SimpleVideoModel addVideo(VideoEntity video, Long rating_id) throws AgeRatingNotFoundException {
        // ошибки
        // нет такого возрастнного рейтинга
        if (!ratingRepo.existsById(rating_id)){
            throw new AgeRatingNotFoundException("Указанный возрастной рейтинг не существует");
        }

        AgeRatingEntity ageRating = ratingRepo.findById(rating_id).get();

        video.setRating(ageRating);

        return SimpleVideoModel.toModel(videoRepo.save(video));
    }

    public void deleteVideo(Long id) throws VideoNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!videoRepo.existsById(id)){
            throw new VideoNotFoundException("Указанного видео не существует");
        }
        videoRepo.deleteById(id);
    }

    public SimpleVideoModel editVideo(VideoEntity video, Long rating_id, Long video_id) throws VideoNotFoundException, AgeRatingNotFoundException {
        // ошибки
        // есть ли такое видео
        // нет такого возрастнного рейтинга
        // не меняет конкретные жанры и конкретных создателей видео
        // VideoEntity videoEntity = videoRepo.findById(video_id).get();

        if (!videoRepo.existsById(video_id)){//(videoEntity == null){
            throw new VideoNotFoundException("Видео не найдено");
        }

        if (!ratingRepo.existsById(rating_id)){
            throw new AgeRatingNotFoundException("Указанного возрастного рейтинга не существует");
        }

        VideoEntity videoEntity = videoRepo.findById(video_id).get();

        if (!rating_id.equals(videoEntity.getRating().getId())) {
            AgeRatingEntity ageRating = ratingRepo.findById(rating_id).get();
            videoEntity.setRating(ageRating);
        }

        videoEntity.setComments(video.getComments());
        videoEntity.setAdd_date(video.getAdd_date());
        //videoEntity.setDef_creators(video.getDef_creators());
        videoEntity.setDescription(video.getDescription());
        videoEntity.setDuration(video.getDuration());
        videoEntity.setName(video.getName());
        videoEntity.setTrailer_link(video.getTrailer_link());
        videoEntity.setTime_codes(video.getTime_codes());
        videoEntity.setReviews(video.getReviews());
        //videoEntity.setDef_genres(video.getDef_genres());
        videoEntity.setPoster_path(video.getPoster_path());
        videoEntity.setRelease_year(video.getRelease_year());
        videoEntity.setTagline(video.getTagline());

        return SimpleVideoModel.toModel(videoRepo.save(videoEntity));
    }

    public SimpleVideoModel getSimpleVideoById(Long id) throws VideoNotFoundException {
        // какая то проверка
        if (!videoRepo.existsById(id)){
            throw new VideoNotFoundException("Указанного видео не существует");
        }
        VideoEntity video = videoRepo.findById(id).get();
        return SimpleVideoModel.toModel(video);
    }

    public List<SimpleVideoModel> getPageOfSimpleVideoByParams(Pageable page){
        // какая то проверка
        //List<VideoEntity> videos = videoRepo.findByNameIgnoreCase(name, page);

        List<VideoEntity> videos = videoRepo.findAll(page);

        return videos.stream().map(SimpleVideoModel::toModel).collect(Collectors.toList());
    }

    public ExtendedVideoModel getExtendedVideoById(Long id) throws VideoNotFoundException {
        // какая то проверка
        if (!videoRepo.existsById(id)){
            throw new VideoNotFoundException("Указанного видео не существует");
        }
        VideoEntity video = videoRepo.findById(id).get();
        return ExtendedVideoModel.toModel(video);
    }

}
