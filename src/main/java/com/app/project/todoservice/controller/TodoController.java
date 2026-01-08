package com.app.project.todoservice.controller;

import com.app.project.todoservice.error.ItemNotFoundException;
import com.app.project.todoservice.model.dto.ItemDTO;
import com.app.project.todoservice.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public void addItem(@Valid @RequestBody ItemDTO itemDTO) {
        todoService.addItem(itemDTO);
    }

    @PutMapping("/update/{id}")
    public void updateItem(@PathVariable int id, @Valid @RequestBody ItemDTO itemDTO) {
        todoService.updateItem(id, itemDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable int id) {
        todoService.deleteItem(id);
    }

    @GetMapping("/search/{id}")
    public ItemDTO getItem(@PathVariable int id) {
        return todoService.getItemById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));
    }

    @GetMapping("/searchAll")
    public List<ItemDTO> getAllItems() {
        return todoService.findAllItems();
    }

    @GetMapping("/searchByTitle")
    public List<ItemDTO> getItemsByTitle(@RequestParam String title) {
        return todoService.findItemsByTitle(title);
    }


}
