package com.example.inventory_management.controller;

import com.example.inventory_management.entity.WarehouseInventory;
import com.example.inventory_management.service.WarehouseInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouse-inventory")
public class WarehouseInventoryController {
    private final WarehouseInventoryService warehouseInventoryService;

    public WarehouseInventoryController(WarehouseInventoryService warehouseInventoryService) {
        this.warehouseInventoryService = warehouseInventoryService;
    }

    @GetMapping
    public List<WarehouseInventory> getAllWarehouseInventories() {
        return warehouseInventoryService.getAllWarehouseInventories();
    }

    @GetMapping("/{warehouseId}/{productId}")
    public ResponseEntity<WarehouseInventory> getWarehouseInventoryById(@PathVariable Integer warehouseId, @PathVariable Integer productId) {
        return warehouseInventoryService.getWarehouseInventoryById(warehouseId, productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WarehouseInventory createWarehouseInventory(@RequestBody WarehouseInventory warehouseInventory) {
        return warehouseInventoryService.saveWarehouseInventory(warehouseInventory);
    }

    @DeleteMapping("/{warehouseId}/{productId}")
    public ResponseEntity<Void> deleteWarehouseInventory(@PathVariable Integer warehouseId, @PathVariable Integer productId) {
        warehouseInventoryService.deleteWarehouseInventory(warehouseId, productId);
        return ResponseEntity.noContent().build();
    }
}
