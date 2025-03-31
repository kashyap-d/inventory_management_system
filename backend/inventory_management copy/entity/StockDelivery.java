package com.example.inventory_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stock_delivery")
public class StockDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "outlet_id", nullable = false)
    private Outlet outlet;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @OneToMany(mappedBy = "stockDelivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryDetails> deliveryDetails;
}
