package com.cambodia.udemy.project.config;

import com.cambodia.udemy.project.dto.CustomErrorResponseException;
import com.cambodia.udemy.project.exception.CustomBadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<CustomErrorResponseException> handleNotFound(CustomBadRequestException customBadRequestException){
        CustomErrorResponseException responseException = CustomErrorResponseException.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(customBadRequestException.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseException);
    }
}
