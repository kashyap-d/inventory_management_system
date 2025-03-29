package com.example.inventory_management.repository;

import com.example.inventory_management.entity.TransactionDetails;
import com.example.inventory_management.entity.TransactionDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, TransactionDetailsId> {
}
