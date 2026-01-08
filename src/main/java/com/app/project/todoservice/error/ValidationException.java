package com.app.project.todoservice.error;

import lombok.Getter;

public class ValidationException extends RuntimeException {

    public static final int STATUS_CODE = 10001;
    public static final String MESSAGE = "ValidationFailed";
    @Getter
    private final String description;

    public ValidationException(String description) {
        super(description);
        this.description = description;
    }
}
