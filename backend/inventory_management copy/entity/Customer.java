package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(nullable = false, length = 100)
    private String customerName;

    @Column(length = 50)
    private String contact;

    @Column(length = 100)
    private String email;
}
