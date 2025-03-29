package com.example.inventory_management.repository;

import com.example.inventory_management.entity.DeliveryDetails;
import com.example.inventory_management.entity.DeliveryDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, DeliveryDetailsId> {
}
