package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "outlet_id", nullable = false)
    private Outlet outlet;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double totalAmount;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionDetails> transactionDetails;
}
