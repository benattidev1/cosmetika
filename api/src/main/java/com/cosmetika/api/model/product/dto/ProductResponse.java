package com.cosmetika.api.model.product.dto;

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
public class ProductResponse {

    private UUID id;
    private String name;
    private String description;
    private String sku;
    private String barcode;
    private BigDecimal currentStock;
    private BigDecimal minStock;
    private String unit;
    private BigDecimal costPrice;
    private BigDecimal salePrice;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
