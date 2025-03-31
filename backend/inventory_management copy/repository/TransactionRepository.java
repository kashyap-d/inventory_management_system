package com.example.inventory_management.repository;

import com.example.inventory_management.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByOutlet_OutletID(Integer outletId);
    List<Transaction> findByCustomer_CustomerID(Integer customerId);
}
