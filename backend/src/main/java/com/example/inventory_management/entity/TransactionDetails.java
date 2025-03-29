package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@IdClass(TransactionDetailsId.class)
public class TransactionDetails {
    @Id
    @Column(name = "transactionID")
    private int transactionID;  // Primary Key Part 1

    @Id
    @Column(name = "productID")
    private int productID;  // Primary Key Part 2

    @ManyToOne
    @JoinColumn(name = "transactionID", insertable = false, updatable = false)
    private TransactionTable transaction;

    @ManyToOne
    @JoinColumn(name = "productID", insertable = false, updatable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;
}
