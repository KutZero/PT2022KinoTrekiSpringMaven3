package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import com.example.PT2022KinoTrekiSpringMaven.exeption.smallExceptions.AgeRatingNotFoundException;

public interface SmallService <T,MODEL, TException extends Throwable>{
    MODEL createEntity(T entity);
    MODEL getEntity(Long id) throws TException;
    void deleteEntity(Long id) throws TException;
}
