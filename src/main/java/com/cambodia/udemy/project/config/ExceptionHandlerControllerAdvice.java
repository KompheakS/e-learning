package com.cambodia.udemy.project.config;

import com.cambodia.udemy.project.exception.CustomBadRequestException;
import com.cambodia.udemy.project.exception.CustomErrorResponseException;
import com.cambodia.udemy.project.exception.GlobalException;
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

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleUnauthorized(GlobalException exception){
        CustomErrorResponseException<Object> customErrorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.UNAUTHORIZED.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customErrorResponseException);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleForbidden(GlobalException exception){
        CustomErrorResponseException<Object> errorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.FORBIDDEN.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponseException);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleNotFound(GlobalException exception){
        CustomErrorResponseException<Object> errorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseException);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<CustomErrorResponseException<?>> handleInternalServerError(GlobalException exception){
        CustomErrorResponseException<Object> errorResponseException = CustomErrorResponseException.builder()
                .timeStamp(new Date())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseException);
    }
}
