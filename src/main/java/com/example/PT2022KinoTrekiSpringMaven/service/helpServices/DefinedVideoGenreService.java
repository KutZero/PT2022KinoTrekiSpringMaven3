package com.example.PT2022KinoTrekiSpringMaven.service.helpServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedVideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.VideoGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.helpExceptions.DefinedVideoGenreNorFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.VideoGenreNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedVideoGenre;
import com.example.PT2022KinoTrekiSpringMaven.repository.helpRepos.DefinedVideoGenreRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.VideoGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefinedVideoGenreService {

    @Autowired
    private DefinedVideoGenreRepo definedVideoGenreRepo;

    @Autowired
    private VideoGenreRepo videoGenreRepo;

    @Autowired
    private VideoRepo videoRepo;

    public DefinedVideoGenre addDefinedVideoGenre(Long video_id, Long video_genre_id) throws VideoNotFoundException, VideoGenreNotFountExceptioin {
        // ошибки
        // нет такого видео
        // нет такого жанра видео
        // такой конретный создатель уже существует

        DefinedVideoGenreEntity definedVideoGenreEntity = new DefinedVideoGenreEntity();

        if (!videoRepo.existsById(video_id)){
            throw new VideoNotFoundException("Указанного видео не существует");
        }

        if (!videoGenreRepo.existsById(video_id)){
            throw new VideoGenreNotFountExceptioin("Указанного жанра видео не существует");
        }

        VideoEntity video = videoRepo.findById(video_id).get();
        VideoGenreEntity videoGenre = videoGenreRepo.findById(video_genre_id).get();

        definedVideoGenreEntity.setVideo(video);
        definedVideoGenreEntity.setGenre(videoGenre);

        /*if(!definedCreatorRepo.existsByVideoAndCreator(video_id, creator_id)){
            throw new DefinedCreatorAlreadyExistException("Указанный создатель уже существует");
        }*/

        //definedCreator.setRating(ageRating);
        return DefinedVideoGenre.toModel(definedVideoGenreRepo.save(definedVideoGenreEntity));
    }

    public void deleteDefinedVideoGenre(Long id) throws  DefinedVideoGenreNorFoundException {

        if(!definedVideoGenreRepo.existsById(id)){
            throw new DefinedVideoGenreNorFoundException("Указанного конкретного жанра видео не существует");
        }
        definedVideoGenreRepo.deleteById(id);
    }

    public DefinedVideoGenre getDefinedVideoGenre(Long id) throws DefinedVideoGenreNorFoundException {

        if(!definedVideoGenreRepo.existsById(id)){
            throw new DefinedVideoGenreNorFoundException("Указанного конкретного жанра видео не существует");
        }

        return DefinedVideoGenre.toModel(definedVideoGenreRepo.findById(id).get());
    }


}
