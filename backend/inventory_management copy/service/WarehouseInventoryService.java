package com.example.inventory_management.service;

import com.example.inventory_management.entity.WarehouseInventory;
import com.example.inventory_management.repository.WarehouseInventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseInventoryService {
    private final WarehouseInventoryRepository warehouseInventoryRepository;

    public WarehouseInventoryService(WarehouseInventoryRepository warehouseInventoryRepository) {
        this.warehouseInventoryRepository = warehouseInventoryRepository;
    }

    public List<WarehouseInventory> getAllWarehouseInventories() {
        return warehouseInventoryRepository.findAll();
    }

    public Optional<WarehouseInventory> getWarehouseInventoryById(Integer warehouseId, Integer productId) {
        return warehouseInventoryRepository.findByWarehouse_WarehouseIDAndProduct_ProductID(warehouseId, productId);
    }

    public WarehouseInventory saveWarehouseInventory(WarehouseInventory warehouseInventory) {
        return warehouseInventoryRepository.save(warehouseInventory);
    }

    public void deleteWarehouseInventory(Integer warehouseId, Integer productId) {
        warehouseInventoryRepository.deleteByWarehouse_WarehouseIDAndProduct_ProductID(warehouseId, productId);
    }
}

