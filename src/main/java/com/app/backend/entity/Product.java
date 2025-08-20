package com.app.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal price;

    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Product(String name, BigDecimal price, int stock, Category category) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
}
