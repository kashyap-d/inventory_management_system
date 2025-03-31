package com.example.inventory_management.repository;

import com.example.inventory_management.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer> {
    Optional<TransactionDetails> findByTransaction_TransactionIDAndProduct_ProductID(Integer transactionId, Integer productId);
    void deleteByTransaction_TransactionIDAndProduct_ProductID(Integer transactionId, Integer productId);
}
