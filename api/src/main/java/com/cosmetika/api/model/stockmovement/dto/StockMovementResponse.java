package com.cosmetika.api.model.stockmovement.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockMovementResponse {

    private UUID id;
    private String movementType;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private LocalDateTime movementDate;
    private String notes;
    private LocalDateTime createdAt;

}
