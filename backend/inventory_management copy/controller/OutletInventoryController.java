package com.example.inventory_management.controller;

import com.example.inventory_management.entity.OutletInventory;
import com.example.inventory_management.service.OutletInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/outlet-inventory")
public class OutletInventoryController {
    private final OutletInventoryService outletInventoryService;

    public OutletInventoryController(OutletInventoryService outletInventoryService) {
        this.outletInventoryService = outletInventoryService;
    }

    @GetMapping
    public List<OutletInventory> getAllOutletInventories() {
        return outletInventoryService.getAllOutletInventories();
    }

    @GetMapping("/{outletId}/{productId}")
    public ResponseEntity<OutletInventory> getOutletInventoryById(@PathVariable Integer outletId, @PathVariable Integer productId) {
        return outletInventoryService.getOutletInventoryById(outletId, productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OutletInventory createOutletInventory(@RequestBody OutletInventory outletInventory) {
        return outletInventoryService.saveOutletInventory(outletInventory);
    }

    @DeleteMapping("/{outletId}/{productId}")
    public ResponseEntity<Void> deleteOutletInventory(@PathVariable Integer outletId, @PathVariable Integer productId) {
        outletInventoryService.deleteOutletInventory(outletId, productId);
        return ResponseEntity.noContent().build();
    }
}
