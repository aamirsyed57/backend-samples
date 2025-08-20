package com.app.backend.event;

import lombok.Data;

@Data
public class ProductAdded {
    String productId;
    String productName;
    Double price;
    int stock;

}
