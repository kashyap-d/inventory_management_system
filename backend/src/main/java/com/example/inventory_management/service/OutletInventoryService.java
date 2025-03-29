package com.example.inventory_management.service;

import com.example.inventory_management.entity.OutletInventory;
import com.example.inventory_management.entity.OutletInventoryId;
import com.example.inventory_management.repository.OutletInventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OutletInventoryService {
    private final OutletInventoryRepository outletInventoryRepository;

    public OutletInventoryService(OutletInventoryRepository outletInventoryRepository) {
        this.outletInventoryRepository = outletInventoryRepository;
    }

    // Get all outlet inventory records
    public List<OutletInventory> getAllOutletInventory() {
        return outletInventoryRepository.findAll();
    }

    // Get a specific outlet inventory record
    public Optional<OutletInventory> getOutletInventory(Integer outletId, Integer productId) {
        OutletInventoryId id = new OutletInventoryId(outletId, productId);
        return outletInventoryRepository.findById(id);
    }

    // Add or update an outlet inventory record
    public OutletInventory saveOutletInventory(OutletInventory outletInventory) {
        return outletInventoryRepository.save(outletInventory);
    }

    // Delete an outlet inventory record
    public void deleteOutletInventory(Integer outletId, Integer productId) {
        OutletInventoryId id = new OutletInventoryId(outletId, productId);
        outletInventoryRepository.deleteById(id);
    }

    // Update quantity of a product in an outlet
    public OutletInventory updateQuantity(Integer outletId, Integer productId, Integer newQuantity) {
        OutletInventoryId id = new OutletInventoryId(outletId, productId);
        return outletInventoryRepository.findById(id)
                .map(inventory -> {
                    inventory.setQuantity(newQuantity);
                    return outletInventoryRepository.save(inventory);
                })
                .orElse(null);
    }
}
