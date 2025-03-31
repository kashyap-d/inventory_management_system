package com.example.inventory_management.repository;

import com.example.inventory_management.entity.WarehouseInventory;
import com.example.inventory_management.entity.Warehouse;
import com.example.inventory_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory, Integer> {
    Optional<WarehouseInventory> findByWarehouse_WarehouseIDAndProduct_ProductID(Integer warehouseId, Integer productId);
    void deleteByWarehouse_WarehouseIDAndProduct_ProductID(Integer warehouseId, Integer productId);
}
