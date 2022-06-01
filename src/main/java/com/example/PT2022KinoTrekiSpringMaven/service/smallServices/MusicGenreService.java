package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.CreatorRoleNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.MusicGenreNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CreatorRole;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.MusicGenre;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.MusicGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicGenreService implements SmallService<MusicGenreEntity, MusicGenre, MusicGenreNotFoundException>{

    @Autowired
    private MusicGenreRepo musicGenreRepo;

    @Override
    public MusicGenre createEntity(MusicGenreEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return MusicGenre.toModel(musicGenreRepo.save(entity));
    }

    @Override
    public MusicGenre getEntity(Long id) throws MusicGenreNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!musicGenreRepo.existsById(id)){
            throw new MusicGenreNotFoundException("Такого музыкального жанра не существует");
        }
        return MusicGenre.toModel(musicGenreRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws MusicGenreNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!musicGenreRepo.existsById(id)){
            throw new MusicGenreNotFoundException("Такого музыкального жанра не существует");
        }
        musicGenreRepo.deleteById(id);
    }
}
