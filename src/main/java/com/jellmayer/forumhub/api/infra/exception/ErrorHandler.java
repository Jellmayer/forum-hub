package com.jellmayer.forumhub.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> entityNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity fieldNotValid(MethodArgumentNotValidException e){
        var fieldErrors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(fieldErrors.stream().map(FieldErrorsValidation::new).toList());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity invalidFormatError(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity duplicateEntry(SQLIntegrityConstraintViolationException e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record FieldErrorsValidation(String field, String message){
        public FieldErrorsValidation(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
