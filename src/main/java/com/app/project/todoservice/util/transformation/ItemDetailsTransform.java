package com.app.project.todoservice.util.transformation;

import com.app.project.todoservice.model.dto.ItemDetailsDTO;
import com.app.project.todoservice.model.entity.ItemDetails;
import java.time.LocalDateTime;
import static com.app.project.todoservice.util.transformation.Utils.getRandomInt;

public class ItemDetailsTransform {
    private ItemDetailsTransform() {
    }

    public static ItemDetails toItemDetails(ItemDetailsDTO itemDetailsDTO) {
        return ItemDetails.builder()
                .id(getRandomInt())
                .description(itemDetailsDTO.getDescription())
                .priority(itemDetailsDTO.getPriority())
                .status(itemDetailsDTO.getStatus())
                .build();
    }

    public static ItemDetailsDTO toItemDetailsDTO(ItemDetails itemDetails) {
        return ItemDetailsDTO.builder()
                .description(itemDetails.getDescription())
                .priority(itemDetails.getPriority())
                .status(itemDetails.getStatus())
                .build();
    }
}
