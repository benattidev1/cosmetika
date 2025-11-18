package com.cosmetika.api.model.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cosmetika.api.model.person.Person;
import com.cosmetika.api.model.saleitem.SaleItem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "sale_date")
    private LocalDateTime saleDate = LocalDateTime.now();

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(name = "discount", precision = 10, scale = 2)
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "status", length = 20)
    private String status = "PENDING";

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "notes")
    @Lob
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Person customer;

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    private List<SaleItem> items;

}
