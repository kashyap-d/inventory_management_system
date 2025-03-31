package com.example.inventory_management.controller;

import com.example.inventory_management.entity.StockDelivery;
import com.example.inventory_management.service.StockDeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock-deliveries")
public class StockDeliveryController {
    private final StockDeliveryService stockDeliveryService;

    public StockDeliveryController(StockDeliveryService stockDeliveryService) {
        this.stockDeliveryService = stockDeliveryService;
    }

    @GetMapping
    public List<StockDelivery> getAllStockDeliveries() {
        return stockDeliveryService.getAllStockDeliveries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDelivery> getStockDeliveryById(@PathVariable Integer id) {
        return stockDeliveryService.getStockDeliveryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StockDelivery createStockDelivery(@RequestBody StockDelivery stockDelivery) {
        return stockDeliveryService.saveStockDelivery(stockDelivery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockDelivery(@PathVariable Integer id) {
        stockDeliveryService.deleteStockDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
