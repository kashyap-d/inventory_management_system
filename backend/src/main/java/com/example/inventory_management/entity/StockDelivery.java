package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
public class StockDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryID;

    @ManyToOne
    @JoinColumn(name = "warehouseID", nullable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "outletID", nullable = false)
    private Outlet outlet;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date deliveryDate;
}
