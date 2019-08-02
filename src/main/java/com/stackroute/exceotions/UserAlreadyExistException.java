package com.stackroute.exceotions;

public class UserAlreadyExistException extends Exception {

    String message;

    public UserAlreadyExistException() {
    }

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
