package com.example.inventory_management.controller;

import com.example.inventory_management.entity.OutletInventory;
import com.example.inventory_management.entity.WarehouseInventory;
import com.example.inventory_management.service.OutletInventoryService;
import com.example.inventory_management.service.WarehouseInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final WarehouseInventoryService warehouseInventoryService;
    private final OutletInventoryService outletInventoryService;

    public InventoryController(WarehouseInventoryService warehouseInventoryService, OutletInventoryService outletInventoryService) {
        this.warehouseInventoryService = warehouseInventoryService;
        this.outletInventoryService = outletInventoryService;
    }

    // Get all warehouse inventory
    @GetMapping("/warehouse")
    public List<WarehouseInventory> getAllWarehouseInventory() {
        return warehouseInventoryService.getAllWarehouseInventory();
    }

    // Get specific warehouse inventory item
    @GetMapping("/warehouse/{warehouseId}/{productId}")
    public ResponseEntity<WarehouseInventory> getWarehouseInventory(@PathVariable Integer warehouseId, @PathVariable Integer productId) {
        Optional<WarehouseInventory> inventory = warehouseInventoryService.getWarehouseInventory(warehouseId, productId);
        return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update warehouse inventory quantity
    @PutMapping("/warehouse/{warehouseId}/{productId}/updateQuantity/{newQuantity}")
    public ResponseEntity<WarehouseInventory> updateWarehouseQuantity(@PathVariable Integer warehouseId, @PathVariable Integer productId, @PathVariable Integer newQuantity) {
        WarehouseInventory updated = warehouseInventoryService.updateQuantity(warehouseId, productId, newQuantity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Get all outlet inventory
    @GetMapping("/outlet")
    public List<OutletInventory> getAllOutletInventory() {
        return outletInventoryService.getAllOutletInventory();
    }

    // Get specific outlet inventory item
    @GetMapping("/outlet/{outletId}/{productId}")
    public ResponseEntity<OutletInventory> getOutletInventory(@PathVariable Integer outletId, @PathVariable Integer productId) {
        Optional<OutletInventory> inventory = outletInventoryService.getOutletInventory(outletId, productId);
        return inventory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update outlet inventory quantity
    @PutMapping("/outlet/{outletId}/{productId}/updateQuantity/{newQuantity}")
    public ResponseEntity<OutletInventory> updateOutletQuantity(@PathVariable Integer outletId, @PathVariable Integer productId, @PathVariable Integer newQuantity) {
        OutletInventory updated = outletInventoryService.updateQuantity(outletId, productId, newQuantity);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
