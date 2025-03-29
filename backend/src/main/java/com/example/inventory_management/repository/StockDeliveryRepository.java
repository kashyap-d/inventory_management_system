package com.example.inventory_management.repository;

import com.example.inventory_management.entity.StockDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDeliveryRepository extends JpaRepository<StockDelivery, Integer> {
}
