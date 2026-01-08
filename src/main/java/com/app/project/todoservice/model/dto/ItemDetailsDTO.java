package com.app.project.todoservice.model.dto;

import com.app.project.todoservice.util.Priority;
import com.app.project.todoservice.util.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class ItemDetailsDTO {

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Status is required")
    private Status status;
}
