package com.pixeltechnology.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pixeltechnology.employee.entity.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public @ResponseBody ApiResponse handleException(RecordNotFoundException ex) {
        return new ApiResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
