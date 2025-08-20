package com.app.backend.writemodel;

import com.app.backend.command.AddProduct;
import com.app.backend.command.UpdateStock;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;


@NoArgsConstructor
@Aggregate
public class Product {
    @AggregateIdentifier
    private String id;
    private String name;
    private BigDecimal price;
    private int stock;


    @CommandHandler
    public Product(AddProduct addProductCommand) {
        /* apply(new ProductAdded(addProductCommand.getProductId(),addProductCommand.getProductName(),addProductCommand.getPrice(), addProductCommand.getStock())); */
    }

    @CommandHandler
    public void updateStock(UpdateStock cmd) {
        throw  new UnsupportedOperationException();
    }

}
