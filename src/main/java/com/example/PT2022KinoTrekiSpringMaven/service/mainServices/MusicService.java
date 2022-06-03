package com.example.PT2022KinoTrekiSpringMaven.service.mainServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.MusicEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.MusicNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.MusicGenreNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.mainModels.SimpleMusicModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.MusicRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.MusicGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    private MusicRepo musicRepo;

    @Autowired
    private MusicGenreRepo musicGenreRepo;

    public SimpleMusicModel addMusic(MusicEntity music, Long music_genre_id) throws MusicGenreNotFoundException {
        // ошибки
        // нет такого пользователя
        // нет такого видео
        if (!musicGenreRepo.existsById(music_genre_id)){
            throw new MusicGenreNotFoundException("Указанный музыкальный жанр не существует");
        }

        MusicGenreEntity musicGenre = musicGenreRepo.findById(music_genre_id).get();
        music.setGenre(musicGenre);

        return SimpleMusicModel.toModel(musicRepo.save(music));
    }

    public void deleteMusic(Long id) throws MusicNotFoundException {
        // ошибки
        // есть ли такое видео
        if (!musicRepo.existsById(id)){
            throw new MusicNotFoundException("Указанной песни не существует");
        }
        musicRepo.deleteById(id);
    }

    public SimpleMusicModel getOneSimpleMusicById(Long id) throws MusicNotFoundException {
        // какая то проверка
        if (!musicRepo.existsById(id)){
            throw new MusicNotFoundException("Указанной песни не существует");
        }

        MusicEntity music = musicRepo.findById(id).get();
        return SimpleMusicModel.toModel(music);
    }

}
