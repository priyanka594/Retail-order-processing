package com.usecase.retail.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHelper {
    @ExceptionHandler(value = UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex)
    {
        return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
    }
}
