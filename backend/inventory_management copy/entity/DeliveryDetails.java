package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "delivery_details")
public class DeliveryDetails {

    @Id
    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private StockDelivery stockDelivery;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
