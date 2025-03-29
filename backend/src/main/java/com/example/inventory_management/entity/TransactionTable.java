package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class TransactionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionID;

    @ManyToOne
    @JoinColumn(name = "outletID", nullable = false)
    private Outlet outlet;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date transactionDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalAmount;
}
