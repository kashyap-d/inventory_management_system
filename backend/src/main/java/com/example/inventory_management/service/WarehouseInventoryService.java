package com.example.inventory_management.service;

import com.example.inventory_management.entity.WarehouseInventory;
import com.example.inventory_management.entity.WarehouseInventoryId;
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

    // Get all warehouse inventory records
    public List<WarehouseInventory> getAllWarehouseInventory() {
        return warehouseInventoryRepository.findAll();
    }

    // Get a specific warehouse inventory record
    public Optional<WarehouseInventory> getWarehouseInventory(Integer warehouseId, Integer productId) {
        WarehouseInventoryId id = new WarehouseInventoryId(warehouseId, productId);
        return warehouseInventoryRepository.findById(id);
    }

    // Add or update a warehouse inventory record
    public WarehouseInventory saveWarehouseInventory(WarehouseInventory warehouseInventory) {
        return warehouseInventoryRepository.save(warehouseInventory);
    }

    // Delete a warehouse inventory record
    public void deleteWarehouseInventory(Integer warehouseId, Integer productId) {
        WarehouseInventoryId id = new WarehouseInventoryId(warehouseId, productId);
        warehouseInventoryRepository.deleteById(id);
    }

    // Update quantity of a product in a warehouse
    public WarehouseInventory updateQuantity(Integer warehouseId, Integer productId, Integer newQuantity) {
        WarehouseInventoryId id = new WarehouseInventoryId(warehouseId, productId);
        return warehouseInventoryRepository.findById(id)
                .map(inventory -> {
                    inventory.setQuantity(newQuantity);
                    return warehouseInventoryRepository.save(inventory);
                })
                .orElse(null);
    }
}
