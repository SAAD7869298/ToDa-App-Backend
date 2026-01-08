package com.app.project.todoservice.repository;

import com.app.project.todoservice.model.dto.ItemDTO;
import com.app.project.todoservice.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByTitleContainingIgnoreCase(String title);
}
