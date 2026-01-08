package com.app.project.todoservice.service;

import com.app.project.todoservice.model.dto.ItemDTO;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    void addItem(ItemDTO itemDTO);

    void updateItem(int id, ItemDTO itemDTO);

    void deleteItem(int id);

    Optional<ItemDTO> getItemById(int id);

    List<ItemDTO> findItemsByTitle(String title);

    List<ItemDTO> findAllItems();
}
