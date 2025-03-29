package com.example.inventory_management.entity;

import java.io.Serializable;
import java.util.Objects;

public class OutletInventoryId implements Serializable {
    private Integer outletId;
    private Integer productId;

    public OutletInventoryId() {
    }

    public OutletInventoryId(Integer outletId, Integer productId) {
        this.outletId = outletId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutletInventoryId that = (OutletInventoryId) o;
        return Objects.equals(outletId, that.outletId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outletId, productId);
    }
}
