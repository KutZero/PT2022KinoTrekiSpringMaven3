package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

import java.util.List;

public interface SmallService <T,MODEL, TException extends Throwable>{
    MODEL createEntity(T entity);
    MODEL getEntity(Long id) throws TException;
    void deleteEntity(Long id) throws TException;
    List<MODEL> getAllEntities();
}
