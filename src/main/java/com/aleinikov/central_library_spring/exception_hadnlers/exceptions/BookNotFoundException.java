package com.aleinikov.central_library_spring.exception_hadnlers.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String param, String value) {
        super("Could not find book with param " + param + " \""  + value + "\"");
    }
}
