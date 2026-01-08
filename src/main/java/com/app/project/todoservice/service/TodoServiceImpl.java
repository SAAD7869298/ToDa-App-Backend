package com.app.project.todoservice.service;

import com.app.project.todoservice.error.ItemNotFoundException;
import com.app.project.todoservice.model.dto.ItemDTO;
import com.app.project.todoservice.model.entity.Item;
import com.app.project.todoservice.model.entity.ItemDetails;
import com.app.project.todoservice.repository.ItemRepository;
import com.app.project.todoservice.util.transformation.ItemTransform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService {

    private final ItemRepository itemRepository;

    @Autowired
    public TodoServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void addItem(ItemDTO itemDTO) {
        Item item = ItemTransform.toItem(itemDTO);
        itemRepository.save(item);
        log.info("ItemService is created item");
    }

    @Override
    public void updateItem(int id, ItemDTO itemDTO) {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));

        existingItem.setTitle(itemDTO.getTitle());
        existingItem.setUserId(itemDTO.getUserId());

        if (existingItem.getItemDetails() == null) {
            existingItem.setItemDetails(new ItemDetails());
            existingItem.getItemDetails().setCreatedAt(LocalDateTime.now());
        }

        ItemDetails details = existingItem.getItemDetails();
        details.setDescription(itemDTO.getItemDetails().getDescription());
        details.setPriority(itemDTO.getItemDetails().getPriority());
        details.setStatus(itemDTO.getItemDetails().getStatus());

       itemRepository.save(existingItem);

//        return ItemTransform.toItemDTO(updatedItem);
    }

    @Override
    public void deleteItem(int id) {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException("Item not found");
        }
        itemRepository.deleteById(id);
        log.info("ItemService is deleted");
    }

    @Override
    public Optional<ItemDTO> getItemById(int id) {
        return itemRepository.findById(id)
                .map(ItemTransform::toItemDTO);
    }

    @Override
    public List<ItemDTO> findItemsByTitle(String title) {
        return itemRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(ItemTransform::toItemDTO)
                .toList();
    }

    @Override
    public List<ItemDTO> findAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemTransform::toItemDTO)
                .toList();
    }
}
