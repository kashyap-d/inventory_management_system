package com.example.inventory_management.entity;

import java.io.Serializable;
import java.util.Objects;

public class DeliveryDetailsId implements Serializable {
    private int deliveryID;
    private int productID;

    public DeliveryDetailsId() {}

    public DeliveryDetailsId(int deliveryID, int productID) {
        this.deliveryID = deliveryID;
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryDetailsId that = (DeliveryDetailsId) o;
        return deliveryID == that.deliveryID && productID == that.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryID, productID);
    }
}
