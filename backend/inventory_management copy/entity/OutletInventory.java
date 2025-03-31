package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "outlet_inventory")
public class OutletInventory {

    @Id
    @ManyToOne
    @JoinColumn(name = "outlet_id", nullable = false)
    private Outlet outlet;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
