package com.example.inventory_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable  // Marks this as a composite key for JPA
public class DeliveryDetailsId implements Serializable {

    private static final long serialVersionUID = 1L;  // Ensures compatibility during serialization

    @Column(name = "deliveryID")  // Explicitly mapping to table column
    private Integer deliveryID;

    @Column(name = "productID")  // Explicitly mapping to table column
    private Integer productID;

    public DeliveryDetailsId() {}

    public DeliveryDetailsId(Integer deliveryID, Integer productID) {
        this.deliveryID = deliveryID;
        this.productID = productID;
    }

    public Integer getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryDetailsId that = (DeliveryDetailsId) o;
        return Objects.equals(deliveryID, that.deliveryID) &&
                Objects.equals(productID, that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryID, productID);
    }

    @Override
    public String toString() {
        return "DeliveryDetailsId{" +
                "deliveryID=" + deliveryID +
                ", productID=" + productID +
                '}';
    }
}
