package com.app.backend.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateStock {
    @TargetAggregateIdentifier
    String productId;
    int stock;
}
