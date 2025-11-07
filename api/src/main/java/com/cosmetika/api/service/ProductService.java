package com.cosmetika.api.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetika.api.mapper.ProductMapper;
import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.product.dto.CreateProductRequest;
import com.cosmetika.api.model.product.dto.ProductResponse;
import com.cosmetika.api.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("null")
    @Transactional
    public ProductResponse create(CreateProductRequest request) {
        if (request == null)
            throw new IllegalArgumentException("Request cannot be empty");

        if (productRepository.findBySku(request.getSku()).isPresent())
            throw new IllegalArgumentException("Product with this SKU already exists");

        Product product = ProductMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    public ProductResponse findById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        return ProductMapper.toResponse(product);
    }

    @Transactional(readOnly = true)
    public ProductResponse findBySku(String sku) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with SKU: " + sku));
        return ProductMapper.toResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Transactional
    public ProductResponse update(UUID id, CreateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));

        // validate unique sku if changed
        if (request.getSku() != null && !request.getSku().equals(product.getSku())) {
            if (productRepository.findBySku(request.getSku()).isPresent()) {
                throw new IllegalArgumentException("Product with this SKU already exists");
            }
        }

        ProductMapper.updateEntity(product, request);
        Product updatedProduct = productRepository.save(product);

        return ProductMapper.toResponse(updatedProduct);

    }

    @SuppressWarnings("null")
    @Transactional
    public void delete(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        productRepository.delete(product);
    }
}
