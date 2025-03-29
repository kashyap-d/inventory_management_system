package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(WarehouseInventoryId.class)
public class WarehouseInventory {
    @Id
    @Column(name = "warehouseID")
    private Integer warehouseId;

    @Id
    @Column(name = "productID")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "warehouseID", insertable = false, updatable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "productID", insertable = false, updatable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
