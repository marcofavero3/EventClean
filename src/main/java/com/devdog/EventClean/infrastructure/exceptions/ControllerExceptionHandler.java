package com.devdog.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateExceptionHandle(DuplicateEventException exception){

        Map<String, String> response = new HashMap<>();
        response.put("Error:", exception.getMessage());
        response.put("Message:", "Please insert a valid ID for your event");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundEventException exception){

        Map<String, String> response = new HashMap<>();
        response.put("Error:", exception.getMessage());
        response.put("Message:", "The event was not found, check your ID");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
