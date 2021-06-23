package com.tech_school.core.exceptions.handlers;

import com.tech_school.core.exceptions.ErrorResponse;
import com.tech_school.core.exceptions.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(GeneralException ex) {
        ex.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMsgCode());
        errorResponse.setHttpCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        e.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("sorry, Something went wrong");
        errorResponse.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        e.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Invalid API Key");
        errorResponse.setHttpCode(HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
