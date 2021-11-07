package io.github.tingreavinash.microservice.citizenservice.advice;

import io.github.tingreavinash.microservice.citizenservice.Exception.EmptyInputException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("Input fields are empty, please look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception){
        return new ResponseEntity<String>("No matching entity found in DB for given ID, Please look into it - "+exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
