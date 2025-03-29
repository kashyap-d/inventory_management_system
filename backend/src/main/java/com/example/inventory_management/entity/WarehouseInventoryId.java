package com.example.inventory_management.entity;

import java.io.Serializable;
import java.util.Objects;

public class WarehouseInventoryId implements Serializable {
    private Integer warehouseId;
    private Integer productId;

    // ✅ Empty constructor (required by JPA)
    public WarehouseInventoryId() {
    }

    // ✅ Parameterized constructor (needed for service methods)
    public WarehouseInventoryId(Integer warehouseId, Integer productId) {
        this.warehouseId = warehouseId;
        this.productId = productId;
    }

    // ✅ Override equals() and hashCode() for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseInventoryId that = (WarehouseInventoryId) o;
        return Objects.equals(warehouseId, that.warehouseId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, productId);
    }
}
