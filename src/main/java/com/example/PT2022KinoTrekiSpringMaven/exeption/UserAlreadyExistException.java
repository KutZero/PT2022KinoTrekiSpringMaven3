package com.example.PT2022KinoTrekiSpringMaven.exeption;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
