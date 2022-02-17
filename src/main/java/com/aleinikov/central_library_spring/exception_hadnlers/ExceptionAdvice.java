package com.aleinikov.central_library_spring.exception_hadnlers;

import com.aleinikov.central_library_spring.exception_hadnlers.exceptions.BookNotFoundException;
import com.aleinikov.central_library_spring.exception_hadnlers.exceptions.LibraryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bookNotFoundHandler(BookNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bookNotFoundHandler(LibraryNotFoundException exception) {
        return exception.getMessage();
    }
}
