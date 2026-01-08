package com.app.project.todoservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
public class ItemDTO {

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters")
    private String title;

    @NotNull(message = "UserId is required")
    private Long userId;

    @NotNull(message = "ItemDetails is required")
    private ItemDetailsDTO itemDetails;
}
