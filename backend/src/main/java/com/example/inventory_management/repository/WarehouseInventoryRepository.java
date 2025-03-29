package com.example.inventory_management.repository;

import com.example.inventory_management.entity.WarehouseInventory;
import com.example.inventory_management.entity.WarehouseInventoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory, WarehouseInventoryId> {
}
