package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.MusicGenreNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.VideoGenreNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.MusicGenre;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.VideoGenre;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.VideoGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoGenreService implements SmallService<VideoGenreEntity, VideoGenre, VideoGenreNotFountExceptioin>{

    @Autowired
    private VideoGenreRepo videoGenreRepo;

    @Override
    public VideoGenre createEntity(VideoGenreEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return VideoGenre.toModel(videoGenreRepo.save(entity));
    }

    @Override
    public VideoGenre getEntity(Long id) throws VideoGenreNotFountExceptioin {
        // Ошибки
        // Такая сущность не существует
        if (!videoGenreRepo.existsById(id)){
            throw new VideoGenreNotFountExceptioin("Такого жанра видео не существует");
        }
        return VideoGenre.toModel(videoGenreRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws VideoGenreNotFountExceptioin {
        // Ошибки
        // Такая сущность не существует
        if (!videoGenreRepo.existsById(id)){
            throw new VideoGenreNotFountExceptioin("Такого жанра видео не существует");
        }
        videoGenreRepo.deleteById(id);
    }
}
