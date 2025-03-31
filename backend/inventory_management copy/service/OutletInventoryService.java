package com.example.inventory_management.service;

import com.example.inventory_management.entity.OutletInventory;
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

    public List<OutletInventory> getAllOutletInventories() {
        return outletInventoryRepository.findAll();
    }

    public Optional<OutletInventory> getOutletInventoryById(Integer outletId, Integer productId) {
        return outletInventoryRepository.findByOutlet_OutletIDAndProduct_ProductID(outletId, productId);
    }

    public OutletInventory saveOutletInventory(OutletInventory outletInventory) {
        return outletInventoryRepository.save(outletInventory);
    }

    public void deleteOutletInventory(Integer outletId, Integer productId) {
        outletInventoryRepository.deleteByOutlet_OutletIDAndProduct_ProductID(outletId, productId);
    }
}
