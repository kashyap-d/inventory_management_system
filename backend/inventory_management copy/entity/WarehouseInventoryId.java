package com.example.inventory_management.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WarehouseInventoryId implements Serializable {
    private Integer warehouseId;
    private Integer productId;
}
