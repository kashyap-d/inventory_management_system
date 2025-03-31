package com.example.inventory_management.repository;

import com.example.inventory_management.entity.TransactionDetails;
import com.example.inventory_management.entity.Transaction;
import com.example.inventory_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer> {
    List<TransactionDetails> findByTransaction_TransactionID(Integer transactionId);
    void deleteByTransaction_TransactionIDAndProduct_ProductID(Integer transactionId, Integer productId);
}
