package com.cosmetika.api.mapper;

import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.product.dto.CreateProductRequest;
import com.cosmetika.api.model.product.dto.ProductResponse;

public class ProductMapper {

    private ProductMapper() {
    }

    public static Product toEntity(CreateProductRequest request) {
        Product product = new Product();

        if (request.getName() != null)
            product.setName(request.getName());

        if (request.getDescription() != null)
            product.setDescription(request.getDescription());

        if (request.getSku() != null)
            product.setSku(request.getSku());

        if (request.getBarcode() != null)
            product.setBarcode(request.getBarcode());

        if (request.getCurrentStock() != null)
            product.setCurrentStock(request.getCurrentStock());

        if (request.getMinStock() != null)
            product.setMinStock(request.getMinStock());

        if (request.getUnit() != null)
            product.setUnit(request.getUnit());

        if (request.getCostPrice() != null)
            product.setCostPrice(request.getCostPrice());

        if (request.getSalePrice() != null)
            product.setSalePrice(request.getSalePrice());

        if (request.getActive() != null)
            product.setActive(request.getActive());

        return product;
    }

    public static void updateEntity(Product product, CreateProductRequest request) {
        if (request.getName() != null)
            product.setName(request.getName());

        if (request.getDescription() != null)
            product.setDescription(request.getDescription());

        if (request.getSku() != null)
            product.setSku(request.getSku());

        if (request.getBarcode() != null)
            product.setBarcode(request.getBarcode());

        if (request.getCurrentStock() != null)
            product.setCurrentStock(request.getCurrentStock());

        if (request.getMinStock() != null)
            product.setMinStock(request.getMinStock());

        if (request.getUnit() != null)
            product.setUnit(request.getUnit());

        if (request.getCostPrice() != null)
            product.setCostPrice(request.getCostPrice());

        if (request.getSalePrice() != null)
            product.setSalePrice(request.getSalePrice());

        if (request.getActive() != null)
            product.setActive(request.getActive());
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
