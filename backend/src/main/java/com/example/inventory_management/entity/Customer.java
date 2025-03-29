package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")  // Ensure the table name is correctly mapped
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")  // Ensure case-sensitive match
    private Integer customerID;

    @Column(name = "CustomerName", nullable = false, length = 100) // Exact match
    private String customerName;

    @Column(name = "Contact", length = 50)  // Match exact column name
    private String contact;

    @Column(name = "Email", length = 100)  // Match exact column name
    private String email;
}
