package com.example.PT2022KinoTrekiSpringMaven.service.smallServices;

public interface SmallService <T,MODEL, TException extends Throwable>{
    MODEL createEntity(T entity);
    MODEL getEntity(Long id) throws TException;
    void deleteEntity(Long id) throws TException;
}
