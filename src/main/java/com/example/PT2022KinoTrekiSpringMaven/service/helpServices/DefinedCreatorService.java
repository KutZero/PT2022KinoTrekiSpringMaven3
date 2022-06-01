package com.example.PT2022KinoTrekiSpringMaven.service.helpServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.exeption.helpExceptions.DefinedCreatorAlreadyExistException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.helpExceptions.DefinedCreatorNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.CreatorNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.exeption.mainExceptions.VideoNotFountExceptioin;
import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.CreatorRoleNotFountExceptioin;
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

    public DefinedCreatorService test(Long video_id){
        return new DefinedCreatorService();
    }

    public DefinedCreatorEntity addDefinedCreator(Long video_id, Long creator_id, Long creator_role_id) throws VideoNotFountExceptioin, CreatorNotFountExceptioin, CreatorRoleNotFountExceptioin{
        // ошибки
        // нет такого видео
        // нет такого создателя
        // нет такой роли создателя
        // такой конретный создатель уже существует

        DefinedCreatorEntity definedCreator = new DefinedCreatorEntity();

        if (!videoRepo.existsById(video_id)){
            throw new VideoNotFountExceptioin("Указанного видео не существует");
        }

        if(!creatorRepo.existsById(creator_id)){
            throw new CreatorNotFountExceptioin("Указанного создателя не существует");
        }

        if(!creatorRoleRepo.existsById(creator_role_id)){
            throw new CreatorRoleNotFountExceptioin("Указанной роли создателя не существует");
        }

        VideoEntity video = videoRepo.findById(video_id).get();
        CreatorEntity creator = creatorRepo.findById(creator_id).get();
        CreatorRoleEntity creatorRole = creatorRoleRepo.findById(creator_role_id).get();

        definedCreator.setVideo(video);
        definedCreator.setCreator(creator);
        definedCreator.setCreator_role(creatorRole);

        /*if(!definedCreatorRepo.existsByVideoAndCreator(video_id, creator_id)){
            throw new DefinedCreatorAlreadyExistException("Указанный создатель уже существует");
        }*/

        //definedCreator.setRating(ageRating);
        return definedCreatorRepo.save(definedCreator);
    }

    public void deleteDefinedCreator(Long id) throws DefinedCreatorNotFoundException {

        if(!definedCreatorRepo.existsById(id)){
            throw new DefinedCreatorNotFoundException("Указанного конкретного создателя не существует");
        }

        definedCreatorRepo.deleteById(id);
    }

    public DefinedCreatorEntity getDefinedCreator(Long id) throws DefinedCreatorNotFoundException {

        if(!definedCreatorRepo.existsById(id)){
            throw new DefinedCreatorNotFoundException("Указанного конкретного создателя не существует");
        }

        return definedCreatorRepo.findById(id).get();
    }

}
