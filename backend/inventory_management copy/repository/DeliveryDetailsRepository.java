package com.example.inventory_management.repository;

import com.example.inventory_management.entity.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, Integer> {
    Optional<DeliveryDetails> findByDelivery_DeliveryIDAndProduct_ProductID(Integer deliveryId, Integer productId);
    void deleteByDelivery_DeliveryIDAndProduct_ProductID(Integer deliveryId, Integer productId);
}
