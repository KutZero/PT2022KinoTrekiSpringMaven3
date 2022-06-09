package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CountryEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.CountryNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.model.smallModels.CountryModel;
import com.example.PT2022KinoTrekiSpringMaven.repository.smallRepos.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService implements SmallService<CountryEntity, CountryModel, CountryNotFoundException>{

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public CountryModel createEntity(CountryEntity entity) {
        return CountryModel.toModel(countryRepo.save(entity));
    }

    @Override
    public CountryModel getEntity(Long id) throws CountryNotFoundException {
        if (!countryRepo.existsById(id)){
            throw new CountryNotFoundException("Такой страны не существует");
        }
        return CountryModel.toModel(countryRepo.findById(id).get());
    }

    @Override
    public void deleteEntity(Long id) throws CountryNotFoundException {
        if (!countryRepo.existsById(id)){
            throw new CountryNotFoundException("Такой страны не существует");
        }
        countryRepo.deleteById(id);
    }

    @Override
    public List<CountryModel> getAllEntities() {
        return countryRepo.findAll().stream().map(CountryModel::toModel).collect(Collectors.toList());
    }
}
