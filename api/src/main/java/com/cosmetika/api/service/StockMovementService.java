package com.cosmetika.api.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetika.api.mapper.StockMovementMapper;
import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.stockmovement.StockMovement;
import com.cosmetika.api.model.stockmovement.dto.StockAdjustmentRequest;
import com.cosmetika.api.model.stockmovement.dto.StockMovementResponse;
import com.cosmetika.api.repository.ProductRepository;
import com.cosmetika.api.repository.StockMovementRepository;

@Service
public class StockMovementService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockMovementRepository movementRepository;

    @Transactional(readOnly = true)
    public List<StockMovementResponse> findByProductId(UUID productId) {
        return movementRepository.findByProductId(productId)
                .stream()
                .map(StockMovementMapper::toResponse)
                .collect(Collectors.toList());

    }

    @SuppressWarnings("null")
    public StockMovementResponse adjustStock(UUID productId, StockAdjustmentRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        // valida se há estoque suficiente para alterar
        if ("OUT".equals(request.getMovementType())) {
            if (product.getCurrentStock().compareTo(request.getQuantity()) < 0) {
                throw new IllegalArgumentException("Insufficient stock. Avalidable:" + product.getCurrentStock()
                        + ", Requisited: " + request.getQuantity());
            }
        }

        // adiciona ou remove do estoque
        if ("IN".equals(request.getMovementType())) {
            product.setCurrentStock(product.getCurrentStock().add(request.getQuantity()));
        } else {
            product.setCurrentStock(product.getCurrentStock().subtract(request.getQuantity()));
        }
        productRepository.save(product);

        StockMovement movement = StockMovementMapper.toEntity(request, product);
        StockMovement savedMovement = movementRepository.save(movement);

        return StockMovementMapper.toResponse(savedMovement);
    }

}
