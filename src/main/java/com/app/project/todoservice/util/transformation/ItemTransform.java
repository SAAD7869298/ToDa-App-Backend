package com.app.project.todoservice.util.transformation;

import com.app.project.todoservice.model.dto.ItemDTO;
import com.app.project.todoservice.model.entity.Item;
import com.app.project.todoservice.model.entity.ItemDetails;
import static com.app.project.todoservice.util.transformation.Utils.getRandomInt;

public class ItemTransform {

    private ItemTransform(){}

    public static Item toItem(ItemDTO itemDTO) {
        ItemDetails itemDetails = ItemDetailsTransform.toItemDetails(itemDTO.getItemDetails());
        return Item.builder()
                .id(getRandomInt())
                .title(itemDTO.getTitle())
                .userId(itemDTO.getUserId())
                .itemDetails(itemDetails)
                .build();
    }

    public static ItemDTO toItemDTO(Item item) {
        return ItemDTO.builder()
                .title(item.getTitle())
                .userId(item.getUserId())
                .itemDetails(ItemDetailsTransform.toItemDetailsDTO(item.getItemDetails()))
                .build();
    }
}
