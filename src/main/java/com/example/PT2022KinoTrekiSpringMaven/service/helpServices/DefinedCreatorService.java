package com.example.PT2022KinoTrekiSpringMaven.service.helpServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.helpExceptions.DefinedCreatorNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.CreatorNotFountException;
import com.example.PT2022KinoTrekiSpringMaven.exception.mainExceptions.VideoNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.CreatorRoleNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.model.helpModels.DefinedCreatorModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.helpRepos.DefinedCreatorRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.CreatorRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.CreatorRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefinedCreatorService {

    @Autowired
    private DefinedCreatorRepo definedCreatorRepo;

    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private CreatorRepo creatorRepo;

    @Autowired
    private CreatorRoleRepo creatorRoleRepo;

    public DefinedCreatorModel addDefinedCreator(Long video_id, Long creator_id, Long creator_role_id) throws VideoNotFoundException, CreatorNotFountException, CreatorRoleNotFountExceptioin{
        // ошибки
        // нет такого видео
        // нет такого создателя
        // нет такой роли создателя
        // такой конретный создатель уже существует

        DefinedCreatorEntity definedCreator = new DefinedCreatorEntity();

        if (!videoRepo.existsById(video_id)){
            throw new VideoNotFoundException("Указанного видео не существует");
        }

        if(!creatorRepo.existsById(creator_id)){
            throw new CreatorNotFountException("Указанного создателя не существует");
        }

        if(!creatorRoleRepo.existsById(creator_role_id)){
            throw new CreatorRoleNotFountExceptioin("Указанной роли создателя не существует");
        }

        VideoEntity video = videoRepo.findById(video_id).get();
        CreatorEntity creator = creatorRepo.findById(creator_id).get();
        CreatorRoleEntity creatorRole = creatorRoleRepo.findById(creator_role_id).get();

        definedCreator.setVideo(video);
        definedCreator.setCreator(creator);
        definedCreator.setCreatorRole(creatorRole);

        /*if(!definedCreatorRepo.existsByVideoAndCreator(video_id, creator_id)){
            throw new DefinedCreatorAlreadyExistException("Указанный создатель уже существует");
        }*/

        //definedCreator.setRating(ageRating);
        return DefinedCreatorModel.toModel(definedCreatorRepo.save(definedCreator));
    }

    public void deleteDefinedCreator(Long id) throws DefinedCreatorNotFoundException {

        if(!definedCreatorRepo.existsById(id)){
            throw new DefinedCreatorNotFoundException("Указанного конкретного создателя не существует");
        }

        definedCreatorRepo.deleteById(id);
    }

    public DefinedCreatorModel getDefinedCreator(Long id) throws DefinedCreatorNotFoundException {

        if(!definedCreatorRepo.existsById(id)){
            throw new DefinedCreatorNotFoundException("Указанного конкретного создателя не существует");
        }

        return DefinedCreatorModel.toModel(definedCreatorRepo.findById(id).get());
    }

}
