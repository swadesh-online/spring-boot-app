package com.veinchain.rest.exception;

import com.veinchain.rest.kafka.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIAe(IllegalArgumentException iae) {
        return new ResponseEntity<>(ApiResponse.build(false, "Oops", null), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
