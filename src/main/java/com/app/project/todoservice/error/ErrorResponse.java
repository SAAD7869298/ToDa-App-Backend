package com.app.project.todoservice.error;

import java.sql.Timestamp;

public record ErrorResponse(int statusCode, String message, String description) {
}
