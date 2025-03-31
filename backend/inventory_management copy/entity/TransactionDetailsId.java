package com.example.inventory_management.entity;

import java.io.Serializable;
import java.util.Objects;

public class TransactionDetailsId implements Serializable {
    private Integer transactionID;
    private Integer productID;

    public TransactionDetailsId() {}

    public TransactionDetailsId(Integer transactionID, Integer productID) {
        this.transactionID = transactionID;
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDetailsId that = (TransactionDetailsId) o;
        return Objects.equals(transactionID, that.transactionID) &&
                Objects.equals(productID, that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, productID);
    }
}
