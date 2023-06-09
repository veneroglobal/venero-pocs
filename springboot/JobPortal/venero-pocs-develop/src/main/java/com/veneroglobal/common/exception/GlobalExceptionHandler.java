package com.veneroglobal.common.exception;


import com.veneroglobal.common.exception.custom.DuplicateEmailException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(1)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DuplicateEmailException.class)
    public ResponseEntity<?> handleDuplicateEmail(){
        return new ResponseEntity<>("Duplicate Email Found", HttpStatus.CONFLICT);
    }
}
