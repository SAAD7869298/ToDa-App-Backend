package com.app.project.todoservice.repository;

import com.app.project.todoservice.model.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {
}
