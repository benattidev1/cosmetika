package com.cosmetika.api.mapper;

import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.product.dto.CreateProductRequest;
import com.cosmetika.api.model.product.dto.ProductResponse;

public class ProductMapper {

    private ProductMapper() {
    }

    public static Product toEntity(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setSku(request.getSku());
        product.setBarcode(request.getBarcode());
        product.setCurrentStock(request.getCurrentStock());
        product.setMinStock(request.getMinStock());
        product.setUnit(request.getUnit());
        product.setCostPrice(request.getCostPrice());
        product.setSalePrice(request.getSalePrice());
        product.setActive(request.getActive());
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .sku(product.getSku())
                .barcode(product.getBarcode())
                .currentStock(product.getCurrentStock())
                .minStock(product.getMinStock())
                .unit(product.getUnit())
                .costPrice(product.getCostPrice())
                .salePrice(product.getSalePrice())
                .active(product.getActive())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

}
