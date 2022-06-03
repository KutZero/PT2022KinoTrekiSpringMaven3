package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.MusicGenreEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.MusicGenreNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.MusicGenreModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.MusicGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicGenreService implements SmallService<MusicGenreEntity, MusicGenreModel, MusicGenreNotFoundException>{

    @Autowired
    private MusicGenreRepo musicGenreRepo;

    @Override
    public MusicGenreModel createEntity(MusicGenreEntity entity) {
        // Ошибки
        // Уже существует такая сущность
        return MusicGenreModel.toModel(musicGenreRepo.save(entity));
    }

    @Override
    public MusicGenreModel getEntity(Long id) throws MusicGenreNotFoundException {
        // Ошибки
        // Такая сущность не существует
        if (!musicGenreRepo.existsById(id)){
            throw new MusicGenreNotFoundException("Такого музыкального жанра не существует");
        }
        return MusicGenreModel.toModel(musicGenreRepo.findById(id).get());
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

    @Override
    public List<MusicGenreModel> getAllEntities() {
        return musicGenreRepo.findAll().stream().map(MusicGenreModel::toModel).collect(Collectors.toList());
    }
}
