package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.AgeRatingEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CountryEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.AgeRatingNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.CountryNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.ExtendedVideoModel;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.SimpleVideoModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.AgeRatingRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.CountryRepo;
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

    @Autowired
    private CountryRepo countryRepo;

    public SimpleVideoModel addVideo(VideoEntity video, Long rating_id, Long country_id) throws AgeRatingNotFoundException, CountryNotFoundException {
        // ошибки
        // нет такого возрастнного рейтинга
        if (!ratingRepo.existsById(rating_id)){
            throw new AgeRatingNotFoundException("Указанный возрастной рейтинг не существует");
        }

        if (!countryRepo.existsById(country_id)){
            throw new CountryNotFoundException("Указанная страна не существует");
        }


        AgeRatingEntity ageRating = ratingRepo.findById(rating_id).get();
        CountryEntity country = countryRepo.findById(country_id).get();

        video.setRating(ageRating);
        video.setCountry(country);

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

    public SimpleVideoModel editVideo(VideoEntity video, Long rating_id, Long country_id, Long video_id) throws VideoNotFoundException, AgeRatingNotFoundException, CountryNotFoundException {
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

        if (!countryRepo.existsById(country_id)){
            throw new CountryNotFoundException("Указанная страна не существует");
        }

        VideoEntity videoEntity = videoRepo.findById(video_id).get();

        if (!rating_id.equals(videoEntity.getRating().getId())) {
            AgeRatingEntity ageRating = ratingRepo.findById(rating_id).get();
            videoEntity.setRating(ageRating);
        }

        if (!country_id.equals(videoEntity.getCountry().getId())) {
            CountryEntity country = countryRepo.findById(country_id).get();
            videoEntity.setCountry(country);
        }

        videoEntity.setComments(video.getComments());
        videoEntity.setAddDate(video.getAddDate());
        //videoEntity.setDef_creators(video.getDef_creators());
        videoEntity.setDescription(video.getDescription());
        videoEntity.setDuration(video.getDuration());
        videoEntity.setName(video.getName());
        videoEntity.setTrailerLink(video.getTrailerLink());
        videoEntity.setTimeCodes(video.getTimeCodes());
        videoEntity.setReviews(video.getReviews());
        //videoEntity.setDef_genres(video.getDef_genres());
        videoEntity.setPosterPath(video.getPosterPath());
        videoEntity.setReleaseYear(video.getReleaseYear());
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

    public Page<SimpleVideoModel> getPageOfSimpleVideo(Pageable page){
        // какая то проверка
        //List<VideoEntity> videos = videoRepo.findByNameIgnoreCase(name, page);

        Page<VideoEntity> videos = videoRepo.findAll(page);

        return videos.map(SimpleVideoModel::toModel);
        //return videos.stream().map(SimpleVideoModel::toModel).collect(Collectors.toList());
    }

    public Page<SimpleVideoModel> getPageOfSimpleVideoByYear(Pageable page, int year){
        // какая то проверка

        Page<VideoEntity> videos = videoRepo.findByReleaseYear(page, year);

        return videos.map(SimpleVideoModel::toModel);
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
