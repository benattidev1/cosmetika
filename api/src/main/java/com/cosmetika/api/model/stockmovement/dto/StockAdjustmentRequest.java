package com.cosmetika.api.model.stockmovement.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockAdjustmentRequest {

    private BigDecimal quantity;
    private String movementType;
    private BigDecimal unitPrice;
    private String notes;

}
