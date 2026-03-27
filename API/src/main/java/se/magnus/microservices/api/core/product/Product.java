package se.magnus.microservices.api.core.product;

import lombok.Data;


public record Product(
        int productId,
        String name,
        int weight
) {}