package com.example.springcloudapp.Advice;

import com.example.springcloudapp.Dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException() {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Product is null");

        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.valueOf(400));

        return responseEntity;

    }
}
