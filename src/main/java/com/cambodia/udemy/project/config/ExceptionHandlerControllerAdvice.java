package com.cambodia.udemy.project.config;

import com.cambodia.udemy.project.exception.*;
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
    public ResponseEntity<CustomErrorResponseException<?>> handleNotFound(CustomBadRequestException customBadRequestException){
        CustomErrorResponseException<Object> responseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(customBadRequestException.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseException);
    }

    @ExceptionHandler(CustomUnauthorizedException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleUnauthorized(CustomUnauthorizedException exception){
        CustomErrorResponseException<Object> customErrorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.UNAUTHORIZED.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customErrorResponseException);
    }

    @ExceptionHandler(CustomForbiddenException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleForbidden(CustomForbiddenException exception){
        CustomErrorResponseException<Object> errorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.FORBIDDEN.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponseException);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleNotFound(CustomNotFoundException exception){
        CustomErrorResponseException<Object> errorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseException);
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleInternalServerError(CustomInternalServerErrorException exception){
        CustomErrorResponseException<Object> errorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseException);
    }
}
