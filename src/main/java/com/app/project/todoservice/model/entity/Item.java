package com.app.project.todoservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_details_id", referencedColumnName = "id")
    private ItemDetails itemDetails;
}
