package com.example.PT2022KinoTrekiSpringMaven.service.helpServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.CreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.mainEntities.VideoEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.helpEntities.DefinedCreatorEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CreatorRoleEntity;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.mainRepos.CreatorRepo;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.mainRepos.VideoRepo;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.helpRepos.DefinedCreatorRepo;
import com.example.PT2022KinoTrekiSpringMaven.reposotory.smallRepos.CreatorRoleRepo;
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

    public DefinedCreatorEntity addDefinedCreator(DefinedCreatorEntity definedCreator, Long video_id, Long creator_id, Long creator_role_id){
        // ошибки
        // нет такого видео
        // нет такого создателя
        // нет такой роли создателя
        VideoEntity video = videoRepo.findById(video_id).get();
        CreatorEntity creator = creatorRepo.findById(creator_id).get();
        CreatorRoleEntity creatorRole = creatorRoleRepo.findById(creator_role_id).get();

        definedCreator.setVideo(video);
        definedCreator.setCreator(creator);
        definedCreator.setCreator_role(creatorRole);

        //definedCreator.setRating(ageRating);
        return definedCreatorRepo.save(definedCreator);
    }

    public void deleteDefinedCreator(Long id){
        // ошибки
        // есть ли такое видео
        definedCreatorRepo.deleteById(id);
    }
}
