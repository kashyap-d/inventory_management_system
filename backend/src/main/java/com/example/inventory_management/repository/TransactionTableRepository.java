package com.example.inventory_management.repository;

import com.example.inventory_management.entity.TransactionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTableRepository extends JpaRepository<TransactionTable, Integer> {
}
