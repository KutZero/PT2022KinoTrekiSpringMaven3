package com.example.PT2022KinoTrekiSpringMaven.model.smallModels;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CountryEntity;
import lombok.Data;

@Data
public class CountryModel {
    private Long id;
    private String name;

    static public CountryModel toModel(CountryEntity entity){
        CountryModel model = new CountryModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }
}
