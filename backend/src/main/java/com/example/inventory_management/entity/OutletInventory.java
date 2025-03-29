package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter
@Setter
@IdClass(OutletInventoryId.class)
public class OutletInventory implements Serializable {

    @Id
    @Column(name = "outletID")
    private Integer outletId;

    @Id
    @Column(name = "productID")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "outletID", insertable = false, updatable = false)
    private Outlet outlet;

    @ManyToOne
    @JoinColumn(name = "productID", insertable = false, updatable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    // Default constructor (required by JPA)
    public OutletInventory() {}

    // Parameterized constructor
    public OutletInventory(Integer outletId, Integer productId, Integer quantity) {
        this.outletId = outletId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
