package com.cosmetika.api.mapper;

import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.stockmovement.StockMovement;
import com.cosmetika.api.model.stockmovement.dto.StockAdjustmentRequest;
import com.cosmetika.api.model.stockmovement.dto.StockMovementResponse;

public class StockMovementMapper {

    private StockMovementMapper() {
    }

    public static StockMovement toEntity(StockAdjustmentRequest request, Product product) {
        StockMovement movement = new StockMovement();

        if (request.getQuantity() != null)
            movement.setQuantity(request.getQuantity());

        if (request.getMovementType() != null)
            movement.setMovementType(request.getMovementType());

        if (request.getUnitPrice() != null)
            movement.setUnitPrice(request.getUnitPrice());

        if (request.getNotes() != null)
            movement.setNotes(request.getNotes());

        // relationships
        if (product != null)
            movement.setProduct(product);

        return movement;
    }

    public static StockMovementResponse toResponse(StockMovement movement) {
        return StockMovementResponse.builder()
                .id(movement.getId())
                .movementType(movement.getMovementType())
                .quantity(movement.getQuantity())
                .unitPrice(movement.getUnitPrice())
                .movementDate(movement.getMovementDate())
                .notes(movement.getNotes())
                .createdAt(movement.getCreatedAt())
                .build();
    }

}
