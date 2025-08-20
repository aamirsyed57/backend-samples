package com.app.backend.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateOrder {
    @TargetAggregateIdentifier
    UUID orderId;
    Long productId;
    Long quantity;

}
