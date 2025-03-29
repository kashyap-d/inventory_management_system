package com.example.inventory_management.entity;

import java.io.Serializable;
import java.util.Objects;

public class TransactionDetailsId implements Serializable {
    private int transactionID;
    private int productID;

    public TransactionDetailsId() {}

    public TransactionDetailsId(int transactionID, int productID) {
        this.transactionID = transactionID;
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDetailsId that = (TransactionDetailsId) o;
        return transactionID == that.transactionID && productID == that.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, productID);
    }
}
