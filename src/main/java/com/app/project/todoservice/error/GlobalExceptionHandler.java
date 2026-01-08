package com.app.project.todoservice.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException exception) {
        log.error("Item Not Found Exception with code: [{}] and message: [{}]",
                ItemNotFoundException.STATUS_CODE, ItemNotFoundException.MESSAGE);

        return new ResponseEntity<>(
                new ErrorResponse(ItemNotFoundException.STATUS_CODE, ItemNotFoundException.MESSAGE,
                        exception.getDescription()),
                HttpStatus.NOT_FOUND
        );
    }

    // 🔴 @Valid errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        StringBuilder description = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                description.append(error.getField())
                        .append(": ")
                        .append(error.getDefaultMessage())
                        .append("; ")
        );

        log.error("Validation error: {}", description);
        return new ResponseEntity<>(
                new ErrorResponse(400, "Validation Failed",
                        description.toString()
                ),
                HttpStatus.BAD_REQUEST
        );
    }
/*
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex) {

        log.error("ValidationException with code: [{}] and message: [{}]",
                ValidationException.STATUS_CODE, ValidationException.MESSAGE);

        return new ResponseEntity<>(
                new ErrorResponse(ValidationException.STATUS_CODE , ValidationException.MESSAGE ,
                        ex.getDescription()
                ),
                HttpStatus.BAD_REQUEST
        );
    }*/
}
