package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.VideoGenreNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.VideoGenreModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.VideoGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoGenreService implements SmallService<VideoGenreEntity, VideoGenreModel, VideoGenreNotFountExceptioin>{

    @Autowired
    private VideoGenreRepo videoGenreRepo;

    @Override
    public VideoGenreModel createEntity(VideoGenreEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return VideoGenreModel.toModel(videoGenreRepo.save(entity));
    }

    @Override
    public VideoGenreModel getEntity(Long id) throws VideoGenreNotFountExceptioin {
        // Ошибки
        // Такая сущность не существует
        if (!videoGenreRepo.existsById(id)){
            throw new VideoGenreNotFountExceptioin("Такого жанра видео не существует");
        }
        return VideoGenreModel.toModel(videoGenreRepo.findById(id).get());
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

    @Override
    public List<VideoGenreModel> getAllEntities() {
        return videoGenreRepo.findAll().stream().map(VideoGenreModel::toModel).collect(Collectors.toList());
    }
}
