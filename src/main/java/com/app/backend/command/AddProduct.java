package com.app.backend.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class AddProduct {
    @TargetAggregateIdentifier
    String productId;
    String productName;
    Double price;
    int stock;

}
