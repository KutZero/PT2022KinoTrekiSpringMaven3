package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.MusicEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.TimeCodeEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.UserEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.MusicNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.TimeCodeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.UserNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.TimeCodeModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.MusicRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.TimeCodeRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.UserRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeCodeService {

    @Autowired
    private TimeCodeRepo timeCodeRepo;

    @Autowired
    private MusicRepo musicRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VideoRepo videoRepo;

    public TimeCodeModel addTimeCode(TimeCodeEntity timeCode, Long music_id, Long user_id, Long video_id) throws MusicNotFoundException, UserNotFoundException, VideoNotFoundException {
        // ошибки
        // нет такого возрастнного рейтинга
        if (!musicRepo.existsById(music_id)){
            throw new MusicNotFoundException("Указанная песня не существует");
        }

        if (!userRepo.existsById(user_id)){
            throw new UserNotFoundException("Указанный пользователь не существует");
        }

        if (!videoRepo.existsById(video_id)){
            throw new VideoNotFoundException("Указанное видео не существует");
        }

        MusicEntity music = musicRepo.findById(music_id).get();
        UserEntity user = userRepo.findById(user_id).get();
        VideoEntity video = videoRepo.findById(video_id).get();

        timeCode.setMusic(music);
        timeCode.setUser(user);
        timeCode.setVideo(video);

        return  TimeCodeModel.toModel(timeCodeRepo.save(timeCode));
    }

    public void deleteTimeCode(Long id) throws TimeCodeNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!timeCodeRepo.existsById(id)){
            throw new TimeCodeNotFoundException("Указанного тайм-кода не существует");
        }
        timeCodeRepo.deleteById(id);
    }

    public TimeCodeModel getSimpleTimeCodeById(Long id) throws TimeCodeNotFoundException {
        // какая то проверка
        //System.out.println(id);
        //VideoEntity video = new VideoEntity(); //videoRepo.findById(id).get();
        if (!timeCodeRepo.existsById(id)){
            throw new TimeCodeNotFoundException("Указанного тайм-кода не существует");
        }
        TimeCodeEntity timeCode = timeCodeRepo.findById(id).get();
        return TimeCodeModel.toModel(timeCode);
    }
}
