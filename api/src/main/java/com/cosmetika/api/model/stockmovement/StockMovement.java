package com.cosmetika.api.model.stockmovement;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.cosmetika.api.model.person.Person;
import com.cosmetika.api.model.product.Product;
import com.cosmetika.api.model.sale.Sale;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock_movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockMovement {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    // @Column(name = "product_id", nullable = false, updatable = false)
    // private UUID productId;

    @Column(name = "movement_type", length = 20)
    private String movementType;

    @Column(name = "quantity", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    // @Column(name = "person_id", updatable = false)
    // private UUID personId;

    // @Column(name = "sale_id", updatable = false)
    // private UUID saleId;

    @Column(name = "movement_date")
    private LocalDateTime movementDate = LocalDateTime.now();

    @Column(name = "notes")
    @Lob
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale sale;

}
