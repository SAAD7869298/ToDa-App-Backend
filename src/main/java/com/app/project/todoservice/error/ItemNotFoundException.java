package com.app.project.todoservice.error;

import lombok.Getter;

public class ItemNotFoundException extends RuntimeException {

    public static final int STATUS_CODE = 10000;
    public static final String MESSAGE = "ItemNotFound";
    @Getter
    private final String description;

    public ItemNotFoundException(String description) {
        super(description);
        this.description = description;
    }
}
