package com.cosmetika.api.model.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cosmetika.api.model.saleitem.SaleItem;
import com.cosmetika.api.model.stockmovement.StockMovement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "sku", length = 50, unique = true)
    private String sku;

    @Column(name = "barcode", length = 50)
    private String barcode;

    @Column(name = "current_stock", precision = 10, scale = 2)
    private BigDecimal currentStock = BigDecimal.ZERO;

    @Column(name = "min_stock", precision = 10, scale = 2)
    private BigDecimal minStock = BigDecimal.ZERO;

    @Column(name = "unit", length = 20)
    private String unit = "UN";

    @Column(name = "cost_price", precision = 10, scale = 2)
    private BigDecimal costPrice = BigDecimal.ZERO;

    @Column(name = "sale_price", precision = 10, scale = 2)
    private BigDecimal salePrice = BigDecimal.ZERO;

    @Column(name = "active")
    private Boolean active = Boolean.TRUE;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // relationships
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<StockMovement> stockMovements;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<SaleItem> saleItems;

}
