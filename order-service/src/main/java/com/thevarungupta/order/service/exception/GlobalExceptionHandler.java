package com.thevarungupta.order.service.exception;

import com.thevarungupta.order.service.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException customException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(customException.getMessage())
                .errorCode(customException.getErrorCode())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(customException.getStatus()));
    }
}
