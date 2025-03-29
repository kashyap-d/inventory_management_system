package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(DeliveryDetailsId.class)
public class DeliveryDetails {
    @Id
    @Column(name = "deliveryID")
    private int deliveryID;  // Primary Key Part 1

    @Id
    @Column(name = "productID")
    private int productID;  // Primary Key Part 2

    @ManyToOne
    @JoinColumn(name = "deliveryID", insertable = false, updatable = false)
    private StockDelivery stockDelivery;

    @ManyToOne
    @JoinColumn(name = "productID", insertable = false, updatable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;
}
