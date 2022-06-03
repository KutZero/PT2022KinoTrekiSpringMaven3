package com.example.PT2022KinoTrekiSpringMaven.controller.smallControllers;

import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.CountryEntity;
import com.example.PT2022KinoTrekiSpringMaven.entity.smallEntities.ReviewTypeEntity;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.CountryNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.exception.smallExceptions.ReviewTypeNotFoundException;
import com.example.PT2022KinoTrekiSpringMaven.service.smallServices.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity addCountry(@RequestBody CountryEntity entity){
        try{
            //ошибки
            // такая сущность уже существует
            // id уже занят
            countryService.createEntity(entity);
            return ResponseEntity.ok("Страна добавлена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка добавления страны");
        }
    }

    @GetMapping
    ResponseEntity getOneCountry(@RequestParam Long id){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(countryService.getEntity(id));
        }
        catch (CountryNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения страны");
        }
    }

    @GetMapping("/all")
    ResponseEntity getAllVideoGenres(){
        try{
            //ошибки
            // такой сущности не существует
            return ResponseEntity.ok(countryService.getAllEntities());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка получения списка стран");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReviewType(@PathVariable Long id){
        try{
            //ошибки
            // такой сущности не существует
            // с ним связаны многие записи (не стоит удалять)
            countryService.deleteEntity(id);
            return ResponseEntity.ok("Страна удалена");
        }
        catch (CountryNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка удаления страны");
        }
    }
}
