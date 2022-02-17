package com.aleinikov.central_library_spring.exception_hadnlers.exceptions;

public class LibraryNotFoundException extends RuntimeException{
    public LibraryNotFoundException(Long id) {
        super("Could not find library with id="+id);
    }
}
